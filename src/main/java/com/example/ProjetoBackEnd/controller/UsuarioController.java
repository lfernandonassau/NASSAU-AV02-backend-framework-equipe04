package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.UsuarioService;
import org.springframework.web.bind.annotation.*; // o * importa todas as classes do pacote, bom saber
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController{
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvarusuario")
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return usuarioService.salvarUsuario(usuario);
    }

    @PutMapping("/atualizaruser")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return usuarioService.atualizarUsuario(usuario);
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }









}