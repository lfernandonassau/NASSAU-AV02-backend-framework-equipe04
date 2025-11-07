package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.EsqueceuSenhaRequest;
import com.example.ProjetoBackEnd.dto.RedefinirSenhaRequest;
import com.example.ProjetoBackEnd.services.RedefinirSenhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class AutenticadorController {

    private final RedefinirSenhaService passwordResetService;

    public AutenticadorController(RedefinirSenhaService passwordResetService) {
        this.passwordResetService = passwordResetService;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@Valid @RequestBody EsqueceuSenhaRequest request) {
        passwordResetService.startReset(request.getEmail());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@Valid @RequestBody RedefinirSenhaRequest request) {
        passwordResetService.finishReset(request.getToken(), request.getNewPassword());
        return ResponseEntity.noContent().build();
    }
}


