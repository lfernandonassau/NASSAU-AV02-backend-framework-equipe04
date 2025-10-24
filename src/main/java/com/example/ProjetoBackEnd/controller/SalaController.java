package com.example.ProjetoBackEnd.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoBackEnd.model.Sala;
import com.example.ProjetoBackEnd.repository.SalaRepository;
import com.example.ProjetoBackEnd.services.SalaService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;
    private final SalaRepository salaRepository;

    public SalaController(SalaRepository salaRepository, SalaService salaService) {
        this.salaRepository = salaRepository;
        this.salaService = salaService;
    }

    @GetMapping("/buscarSalaPorId/{id}")
    public Sala buscarSalaPorId(@PathVariable Long id) {
        return salaService.buscarSalaPorId(id);
    }

    @PostMapping("/salvarSala")
    public Sala salvarSala(@RequestBody Sala sala) {
        return salaService.salvarSala(sala);
    }

    @PutMapping("/atualizarSala")
    public Sala atualizarSala(@RequestBody Sala sala) {
        return salaService.atualizarSala(sala);
    }

    @DeleteMapping("/excluirSala/{id}")
    public void excluirSala(@PathVariable Long id){
        salaService.excluirSala(id);
    }
}