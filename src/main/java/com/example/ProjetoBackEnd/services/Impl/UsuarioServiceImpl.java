package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.dto.LoginRequest;
import com.example.ProjetoBackEnd.dto.LoginResponse;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.JwtTokenService;
import com.example.ProjetoBackEnd.services.UsuarioService;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final JwtTokenService jwtTokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PacienteRepository pacienteRepository, JwtTokenService jwtTokenService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.pacienteRepository = pacienteRepository;
        this.jwtTokenService = jwtTokenService;
        this. authenticationManager= authenticationManager;
    }
    public void validarUsuario(Usuario usuario){
        if(usuario.getNome() == null || usuario.getNome().trim().isEmpty()){
            throw new IllegalArgumentException("nome invalido");
        }
        if(usuario.getEmail() == null || !usuario.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("email invalido");
        }

        if(usuario.getSenha() == null || usuario.getSenha().length() < 8){
            throw new IllegalArgumentException("senha invalida");
        }
        if(usuario.getRole() == null){
            throw new IllegalArgumentException("Trabalho do usuario não definido");
        }

    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {


        validarUsuario(usuario);
        String senha = usuario.getSenha(); //coloca a senha nessa variavel (completamente seguro, eu acho, culpa do celso qualquer coisa)
        String senhaCriptografada = passwordEncoder.encode(senha); //codifica a senha
        usuario.setSenha(senhaCriptografada); // salva a senha
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario user) {
        Usuario novoUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        validarUsuario(user);
        String senha = user.getSenha();
        String email = user.getEmail();
        novoUser.setNome(user.getNome());
        novoUser.setEmail(email);
        novoUser.setSenha(passwordEncoder.encode(senha));
        return usuarioRepository.save(novoUser);
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }
    @Override
    public void excluirUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);


        Usuario usuario = (Usuario) authentication.getPrincipal();


        String token = jwtTokenService.generateToken(usuario);


        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);

        return loginResponse;
    }

    @Override
    public void desativarUser(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Usuario não encontrado para desativar"));
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    @Override
    public void ativarUser(Long id) {

            Usuario usuario = usuarioRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
            usuario.setAtivo(true);
            usuarioRepository.save(usuario);
        }

    }

