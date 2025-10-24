package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.services.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
@CrossOrigin(origins = "[http://localhost:5173](http://localhost:5173)")
public class MedicoController {


private final MedicoService medicoService;

public MedicoController(MedicoService medicoService) {
    this.medicoService = medicoService;
}


@PostMapping("/cadastrar")
public Medico cadastrarMedico(@RequestBody Medico medico) {
    return medicoService.cadastrarMedico(medico);
}


@GetMapping("/buscar/{id}")
public Medico buscarMedicoPorId(@PathVariable Long id) {
    return medicoService.buscarMedicoPorId(id);
}

@PutMapping("/atualizar/{id}")
public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
    return medicoService.atualizarMedico(id, medico);
}


@DeleteMapping("/deletar/{id}")
public void deletarMedico(@PathVariable Long id) {
    medicoService.deletarMedico(id);
}


}
