package com.example.ProjetoBackEnd.controller;

import org.springframework.web.bind.annotation.*; // o * importa todas as classes do pacote, bom saber
import java.util.List;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController{

    private final UsuarioRepository repository;
    public UsuarioController(UsuarioRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return repository.findAll();
    }
    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario){
        return repository.save(usuario);


    }

}