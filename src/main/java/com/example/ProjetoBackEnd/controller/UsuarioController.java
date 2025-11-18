package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.LoginRequest;
import com.example.ProjetoBackEnd.dto.LoginResponse;
import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.web.bind.annotation.*; // o * importa todas as classes do pacote, bom saber
import com.example.ProjetoBackEnd.model.Usuario;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController{
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvar")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/atualizaruser")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(usuario.getId(), usuario);
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @DeleteMapping("deletaruser")
    public void deletarUsuarioPorId(@RequestBody Usuario usuario){
        deletarUsuarioPorId(usuario);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){

        return usuarioService.login(loginRequest);
    }

}