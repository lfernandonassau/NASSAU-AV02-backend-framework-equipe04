package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;

    @PatchMapping("/desativar/{id}")

    public ResponseEntity<Void> desativarUser(@PathVariable Long id){
        usuarioService.desativarUser(id);
        return ResponseEntity.noContent().build();

    }

    @PatchMapping("ativar/{id}")

    public ResponseEntity<Void> ativarUser(@PathVariable Long id){
        usuarioService.ativarUser(id);
        return ResponseEntity.noContent().build();
    }

}
