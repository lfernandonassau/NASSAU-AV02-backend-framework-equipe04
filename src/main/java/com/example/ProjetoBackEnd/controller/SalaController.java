package com.example.ProjetoBackEnd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoBackEnd.dto.SalaDTO;
import com.example.ProjetoBackEnd.dto.SalaResponse;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Sala;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.SalaRepository;
import com.example.ProjetoBackEnd.services.SalaService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService salaService;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    

    public SalaController(SalaRepository salaRepository, SalaService salaService, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.salaService = salaService;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/buscarSalaPorId/{id}")
    public ResponseEntity<SalaResponse> buscarSalaPorId(@PathVariable Long id) {
        Sala sala = salaService.buscarSalaPorId(id);
        SalaResponse salaResponse = new SalaResponse(sala);
        return ResponseEntity.ok(salaResponse);
    }

    @PostMapping("/salvarSala")
    public ResponseEntity<SalaResponse> salvarSala(@RequestBody SalaDTO sala) {
        Sala sala1 = salaService.salvarSala(sala);
        SalaResponse  salaResponse = new SalaResponse(sala1);

        return ResponseEntity.ok(salaResponse);
    }

    @PutMapping("/atualizarSala")
    public ResponseEntity<SalaResponse> atualizarSala(@RequestBody SalaDTO sala) {
        Sala salatt = salaService.atualizarSala(sala);
        SalaResponse  salaResponse = new SalaResponse(salatt);

        return ResponseEntity.ok(salaResponse);
    }

    @DeleteMapping("/excluirSala/{id}")
    public void excluirSala(@PathVariable Long id){
        salaService.excluirSala(id);
    }
}