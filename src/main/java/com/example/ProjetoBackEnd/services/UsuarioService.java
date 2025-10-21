package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService{
    public Usuario salvarUsuario(Usuario usuario);
    public Usuario atualizarUsuario(Usuario usuario);
    public void excluirUsuario(Long id);
    public Usuario buscarUsuarioPorId(Long id);
}