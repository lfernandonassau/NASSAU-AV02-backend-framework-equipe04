package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.PacienteDTO;
import com.example.ProjetoBackEnd.dto.PacienteResponse;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PacienteController {
    private final PacienteService pacienteService;
    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteService pacienteService, PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/buscarpaciente/{nome}")
    public ResponseEntity<PacienteResponse> buscarPaciente(@PathVariable String nome) {

        Paciente paciente = pacienteRepository.findByNome(nome);

        PacienteResponse pacienteResponse = new PacienteResponse(paciente);


        return ResponseEntity.ok(pacienteResponse);
    }

    @PostMapping("/salvarpaciente")
    public ResponseEntity<PacienteResponse> salvarPaciente(@RequestBody PacienteDTO pacienteDTO) {

        Paciente novoPaciente = pacienteService.conversaoDTO(pacienteDTO);
        PacienteResponse pacienteResponse = new PacienteResponse(novoPaciente);
        return ResponseEntity.ok(pacienteResponse);
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
