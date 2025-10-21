package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.AgendamentoRepository;
import com.example.ProjetoBackEnd.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public  class AgendamentoServiceImpl  implements AgendamentoService {
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
        return agendamentoRepository.findByStatusAgendamento(status);
    }


    @Override
    public Agendamento atualizar(Agendamento agendamento) {
        agendamento.setStatusAgendamento(agendamento.getStatusAgendamento());
        agendamento.setMedico(agendamento.getMedico());
        agendamento.setPaciente(agendamento.getPaciente());
        agendamento.setUsuario(agendamento.getUsuario());
        agendamento.setDataInicio(agendamento.getDataInicio());
        agendamento.setDataFim(agendamento.getDataFim());

        return agendamentoRepository.save(agendamento);
    }

    @Override
    public void remover(Integer Id) {
        agendamentoRepository.deleteById(Id);
    }

    public List<Agendamento> verificarHorario(LocalDateTime dataInicio, LocalDateTime dataFim) {

        return agendamentoRepository.findByDataInicioAndDataFim(dataInicio, dataFim);


    }
}
