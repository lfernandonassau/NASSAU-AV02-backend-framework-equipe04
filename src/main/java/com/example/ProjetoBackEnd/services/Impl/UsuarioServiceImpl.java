package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario atualizarUsuario(Usuario user) {
        user.setNome(user.getNome());
        user.setEmail(user.getEmail());
        user.setSenha(user.getSenha());
        return usuarioRepository.save(user);
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