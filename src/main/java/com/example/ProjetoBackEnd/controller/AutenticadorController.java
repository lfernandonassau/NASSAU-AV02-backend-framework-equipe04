package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.ForgotPasswordRequest;
import com.example.ProjetoBackEnd.dto.ResetPasswordRequest;
import com.example.ProjetoBackEnd.services.PasswordResetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final PasswordResetService passwordResetService;

    public AuthController(PasswordResetService passwordResetService) {
        this.passwordResetService = passwordResetService;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        passwordResetService.startReset(request.getEmail());
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Void> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        passwordResetService.finishReset(request.getToken(), request.getNewPassword());
        return ResponseEntity.noContent().build();
    }
}


