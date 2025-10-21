package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
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
        return pacienteService.cadastrarPaciente(paciente);
    }

    @PutMapping("/atualizarcadastropaciente")
    public Paciente atualizarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.atualizarPaciente(paciente);
    }

    @DeleteMapping("/deletarpaciente/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.removerPaciente(id);
    }



}
