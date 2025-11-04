package com.example.ProjetoBackEnd.services;

public interface EmailService {
    void send(String to, String subject, String htmlBody);
}


