package com.example.ProjetoBackEnd.services;

public interface PasswordResetService {
    void startReset(String email);
    void finishReset(String token, String newPassword);
}


