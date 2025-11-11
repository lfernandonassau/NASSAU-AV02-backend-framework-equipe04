package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.RedefinirSenhaToken;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.RedefinirSenhaTokenRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.EmailService;
import com.example.ProjetoBackEnd.services.RedefinirSenhaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class RedefinirSenhaServiceImpl implements RedefinirSenhaService {

    private final UsuarioRepository usuarioRepository;
    private final RedefinirSenhaTokenRepository tokenRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.reset.base-url:http://localhost:5173/reset-password}")
    private String resetBaseUrl;

    public RedefinirSenhaServiceImpl(UsuarioRepository usuarioRepository,
                                    RedefinirSenhaTokenRepository tokenRepository,
                                    EmailService emailService,
                                    PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void startReset(String email) {
        Optional<Usuario> userOpt = usuarioRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            // não revela se o email existe
            return;
        }
        Usuario usuario = userOpt.get();
        RedefinirSenhaToken token = new RedefinirSenhaToken();
        token.setUsuario(usuario);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS));
        tokenRepository.save(token);

        String link = resetBaseUrl + "?token=" + token.getToken();
        String subject = "Redefinição de senha";
        String body = "<p>Olá,</p>" +
                "<p>Recebemos uma solicitação para redefinir sua senha.</p>" +
                "<p>Clique no link abaixo para continuar (expira em 1 hora):</p>" +
                "<p><a href='" + link + "'>Redefinir senha</a></p>" +
                "<p>Se você não solicitou, ignore este e-mail.</p>";
        emailService.send(usuario.getEmail(), subject, body);
    }

    @Override
    public void finishReset(String tokenValue, String newPassword) {
        RedefinirSenhaToken token = tokenRepository.findByToken(tokenValue)
                .orElseThrow(() -> new IllegalArgumentException("Token inválido"));
        if (token.isUsed() || token.getExpiresAt().isBefore(Instant.now())) {
            throw new IllegalArgumentException("Token expirado ou já utilizado");
        }
        Usuario usuario = token.getUsuario();
        usuario.setSenha(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);
        token.setUsed(true);
        tokenRepository.save(token);
    }
}


