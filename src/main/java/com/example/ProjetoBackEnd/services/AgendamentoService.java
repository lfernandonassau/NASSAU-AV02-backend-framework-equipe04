package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.dto.AgendamentoDTO;
import com.example.ProjetoBackEnd.dto.MedicoDTO;
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
    public Agendamento atualizar(int id, AgendamentoDTO agendamento);
    List<Agendamento> verificarHorario(LocalDateTime dataInicio, LocalDateTime dataFim);
    public void remover(Integer id);
    public Agendamento conversaoDTO(AgendamentoDTO agendamentoDTO);


}
