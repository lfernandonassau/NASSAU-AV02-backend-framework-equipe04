package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PacienteRepository pacienteRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PacienteRepository pacienteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pacienteRepository = pacienteRepository;
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



}