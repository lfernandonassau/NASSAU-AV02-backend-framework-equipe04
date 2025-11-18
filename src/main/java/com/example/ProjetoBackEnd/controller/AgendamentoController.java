package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.dto.AgendamentoDTO;
import com.example.ProjetoBackEnd.dto.AgendamentoResponse;
import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.AgendamentoRepository;
import com.example.ProjetoBackEnd.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agendamento")
@CrossOrigin(origins = "http://localhost:5173")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService, AgendamentoRepository agendamentoRepository) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/cadastrarAgendamento")
    public AgendamentoResponse cadastrarAgendamento(@RequestBody AgendamentoDTO agendamentoDTO) {
        Agendamento salvo = agendamentoService.conversaoDTO(agendamentoDTO);
        return new AgendamentoResponse(salvo);
    }

    @GetMapping("/todosagendamentos")
    public List<AgendamentoResponse> todosAgendamentos() {
        return agendamentoService.listarTodos()
                .stream()
                .map(AgendamentoResponse::new)
                .collect(Collectors.toList());
    }


    @PutMapping("/atualizaragendamento/{id}")
    public ResponseEntity<AgendamentoResponse> atualizarAgendamento(@PathVariable int id, @RequestBody AgendamentoDTO agendamento) {
        Agendamento agendamento1 =agendamentoService.atualizar(id, agendamento);
        AgendamentoResponse agendamentoResponse = new AgendamentoResponse(agendamento1);

        return ResponseEntity.ok(agendamentoResponse);
    }

    @DeleteMapping("/deletaragendamento/{id}")
    public void deletarAgendamento(@PathVariable Integer id) {
        agendamentoService.remover(id);
    }


}
