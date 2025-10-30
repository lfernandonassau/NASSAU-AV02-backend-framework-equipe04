package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:5173")
public class PacienteController {
    private final PacienteService pacienteService;
    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteService pacienteService, PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/buscarpaciente/{nome}")
    public Paciente buscarPaciente(@PathVariable String nome) {
        return pacienteService.buscarPacientePorNome(nome);
    }

    @PostMapping("/salvarpaciente")
    public Paciente salvarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.cadastrarPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED).getBody();
    }


    @PutMapping("/atualizarcadastropaciente")
    public Paciente atualizarPaciente(@RequestBody Paciente paciente) {

        return pacienteService.atualizarPaciente(paciente.getId(), paciente);
    }

    @DeleteMapping("/deletarpaciente/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.removerPaciente(id);
    }



}
