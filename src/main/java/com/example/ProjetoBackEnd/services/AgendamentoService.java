package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoService {
    public Agendamento salvar(Agendamento agendamento);
    public List<Agendamento> listarTodos();
    public List<Agendamento> buscarPorPaciente(Paciente paciente);
    public List<Agendamento> buscarPorMedico(Medico medico);
    public List<Agendamento> buscarPorUser (Usuario usuario);
    public List<Agendamento> buscarPorStatus(Boolean status);
    public Agendamento atualizar(Agendamento agendamento);
    public Agendamento atualizarStatus(boolean novoStatus);
    public void remover(Agendamento agendamento);



}
