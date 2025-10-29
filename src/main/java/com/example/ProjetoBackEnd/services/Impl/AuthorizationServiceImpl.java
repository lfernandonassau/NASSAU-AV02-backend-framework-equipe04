package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> user = usuarioRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);

        }
        return user.get();

    }
}
