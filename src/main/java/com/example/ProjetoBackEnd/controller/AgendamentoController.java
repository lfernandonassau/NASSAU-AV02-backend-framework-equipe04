package com.example.ProjetoBackEnd.controller;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.AgendamentoRepository;
import com.example.ProjetoBackEnd.services.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@CrossOrigin(origins = "http://localhost:5173")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoController(AgendamentoService agendamentoService, AgendamentoRepository agendamentoRepository) {
        this.agendamentoService = agendamentoService;
        this.agendamentoRepository = agendamentoRepository;
    }

    @PostMapping("/cadastrarAgendamento")
    public Agendamento cadastrarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    @GetMapping("/todosagendamentos")
    public List<Agendamento> todosAgendamentos() {
        return agendamentoService.listarTodos();
    }

    @GetMapping("/buscarpacientes")
    public List<Agendamento> buscarPacientes(Paciente paciente) {
        return agendamentoService.buscarPorPaciente(paciente);
    }

    @GetMapping("/buscarpormedico")
    public List<Agendamento> buscarPorMedico(Medico medico){
        return agendamentoService.buscarPorMedico(medico);
    }

    @GetMapping("/buscarporuser")
    public List<Agendamento> buscarPorUser(Usuario usuario){
        return agendamentoService.buscarPorUser(usuario);
    }

    @GetMapping("/filtrarstatus")
    public List<Agendamento> filtrarStatus(boolean status){
        return agendamentoService.buscarPorStatus(status);
    }

    @PutMapping("/atualizaragendamento")
    public Agendamento atualizarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.atualizar(agendamento);
    }

    @DeleteMapping("/deletaragendamento")
    public void deletarAgendamento(@PathVariable Integer id) {
        agendamentoService.remover(id);
    }


}
