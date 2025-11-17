package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.MedicoDTO;
import com.example.ProjetoBackEnd.dto.MedicoResponse;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.services.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medico")
@CrossOrigin(origins = "[http://localhost:5173](http://localhost:5173)")
public class MedicoController {

@Autowired
private final MedicoService medicoService ;

public MedicoController(MedicoService medicoService) {
    this.medicoService = medicoService;
}


@PostMapping("/cadastrar")
@Transactional
public ResponseEntity<MedicoResponse> cadastrarMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
    Medico medico = medicoService.cadastrarMedico(medicoDTO);

    MedicoResponse medicoResponse = new MedicoResponse(medico);

    return ResponseEntity.ok(medicoResponse);
}


@GetMapping("/buscar/{id}")
public ResponseEntity<MedicoResponse> buscarMedicoPorId(@PathVariable Long id) {
    Medico medico = medicoService.buscarMedicoPorId(id);
    MedicoResponse medicoResponse = new MedicoResponse(medico);

    return ResponseEntity.ok(medicoResponse);
}

@PutMapping("/atualizar/{id}")
public ResponseEntity<MedicoResponse>atualizarMedico(@PathVariable Long id, @RequestBody MedicoDTO medico) {
    Medico medicoatt = medicoService.atualizarMedico(id, medico);
    MedicoResponse medicoResponse = new MedicoResponse(medicoatt);

    return ResponseEntity.ok(medicoResponse);
}


@DeleteMapping("/deletar/{id}")
public void deletarMedico(@PathVariable Long id) {
    medicoService.deletarMedico(id);
}


}
