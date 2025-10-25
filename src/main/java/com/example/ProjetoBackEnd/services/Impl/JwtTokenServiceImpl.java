package com.example.ProjetoBackEnd.services.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.services.JwtTokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    
    private static final String SECRET_KEY = "minhaChaveSecretaSuperSeguraParaJWTToken123456789";
    private static final long EXPIRATION_TIME = 86400000; // 24 horas em millisegundos
    
    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET_KEY);
    }
    
    @Override
    public String generateToken(Usuario usuario) {
        try {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
            
            return JWT.create()
                    .withSubject(usuario.getEmail())
                    .withIssuedAt(now)
                    .withExpiresAt(expiryDate)
                    .withClaim("userId", usuario.getId())
                    .withClaim("nome", usuario.getNome())
                    .sign(getAlgorithm());
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception);
        }
    }
    
    @Override
    public String getSubjectFromToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(getAlgorithm())
                    .build()
                    .verify(token);
            
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido", exception);
        }
    }
}
