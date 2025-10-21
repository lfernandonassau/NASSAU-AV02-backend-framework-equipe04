package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.AgendamentoRepository;
import com.example.ProjetoBackEnd.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoServiceImpl  implements AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    @Override
    public List<Agendamento> buscarPorPaciente(Paciente paciente) {
        return agendamentoRepository.findByPaciente(paciente);
    }

    @Override
    public List<Agendamento> buscarPorMedico(Medico medico) {
        return agendamentoRepository.findByMedico(medico);
    }

    @Override
    public List<Agendamento> buscarPorUser(Usuario usuario) {
        return agendamentoRepository.findByUsuario(usuario);
    }

    @Override
    public List<Agendamento> buscarPorStatus(Boolean status) {
        return agendamentoRepository.findByStatus(status);
    }


    @Override
    public Agendamento atualizar(Agendamento agendamento) {
        agendamento.setStatus_Agendamento(agendamento.getStatus_Agendamento());
        agendamento.setMedico(agendamento.getMedico());
        agendamento.setPaciente(agendamento.getPaciente());
        agendamento.setUsuario(agendamento.getUsuario());
        agendamento.setDataInicio(agendamento.getDataInicio());
        agendamento.setDataFim(agendamento.getDataFim());

        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento atualizarStatus(boolean novoStatus) {
        return  agendamentoRepository.save(atualizarStatus(novoStatus));
    }

    @Override
    public void remover(Agendamento agendamento) {
        agendamentoRepository.delete(agendamento);

    }
}
