package com.example.ProjetoBackEnd.services;

public interface RedefinirSenhaService {
    void startReset(String email);
    void finishReset(String token, String newPassword);
}


