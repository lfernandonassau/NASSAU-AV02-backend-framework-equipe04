package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Usuario;

public interface JwtTokenService {
    String generateToken(Usuario usuario);
    String getSubjectFromToken(String token);

}
