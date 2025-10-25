package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.dto.LoginRequest;
import com.example.ProjetoBackEnd.dto.LoginResponse;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.JwtTokenService;
import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;
    private final JwtTokenService jwtTokenService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PacienteRepository pacienteRepository, JwtTokenService jwtTokenService) {
        this.usuarioRepository = usuarioRepository;
        this.pacienteRepository = pacienteRepository;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Long id ,Usuario user) {

        Usuario novoUser= usuarioRepository.findById(id)
                .orElseThrow();

        novoUser.setNome(user.getNome());
        novoUser.setEmail(user.getEmail());
        novoUser.setSenha(user.getSenha());
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
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(loginRequest.getEmail());
        
        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        
        Usuario usuario = usuarioOptional.get();
        
        if (!usuario.getSenha().equals(loginRequest.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }
        
        String token = jwtTokenService.generateToken(usuario);
        
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        
        return loginResponse;
    }

}