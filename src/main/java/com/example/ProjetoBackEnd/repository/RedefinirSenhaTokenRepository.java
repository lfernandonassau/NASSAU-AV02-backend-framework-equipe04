package com.example.ProjetoBackEnd.repository;

import com.example.ProjetoBackEnd.model.RedefinirSenhaToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RedefinirSenhaTokenRepository extends JpaRepository<RedefinirSenhaToken, Long> {
    Optional<RedefinirSenhaToken> findByToken(String token);
}


