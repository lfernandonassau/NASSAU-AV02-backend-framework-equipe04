package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.dto.AgendamentoDTO;
import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.AgendamentoRepository;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.AgendamentoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public Agendamento atualizar(int id, Agendamento agendamentoNovosDados) {


        Agendamento agendamentoExistente = agendamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agendamento não encontrado com ID: " + id));


        agendamentoExistente.setStatusAgendamento(agendamentoNovosDados.getStatusAgendamento());
        agendamentoExistente.setMedico(agendamentoNovosDados.getMedico());
        agendamentoExistente.setPaciente(agendamentoNovosDados.getPaciente());
        agendamentoExistente.setUsuario(agendamentoNovosDados.getUsuario());
        agendamentoExistente.setDataInicio(agendamentoNovosDados.getDataInicio());
        agendamentoExistente.setDataFim(agendamentoNovosDados.getDataFim());


        return agendamentoRepository.save(agendamentoExistente);
    }

    @Override
    public void remover(Integer Id) {
        agendamentoRepository.deleteById(Id);
    }

    public List<Agendamento> verificarHorario(LocalDateTime dataInicio, LocalDateTime dataFim) {

        return agendamentoRepository.findByDataInicioAndDataFim(dataInicio, dataFim);


    }

    @Override
    public Agendamento conversaoDTO(AgendamentoDTO agendamentoDTO) {
        // Map via Nomes
        String nomeMedico = agendamentoDTO.getNomeMedico();

        Medico medico = medicoRepository.findByNome(nomeMedico);
        if (medico == null) {
            throw new RuntimeException("Medico: " + nomeMedico + " não encontrado.");
        }
        String nomePaciente = agendamentoDTO.getNomePaciente();
        Paciente paciente = pacienteRepository.findByNome(nomePaciente);
        if (paciente == null) {
            throw new RuntimeException("Paciente: " + nomePaciente + " não encontrado.");
        }
        String nomeUsuario = agendamentoDTO.getNomeUsuario();
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario);

        Agendamento agendamento = new Agendamento();

        agendamento.setDataInicio(agendamentoDTO.getDataInicio());
        agendamento.setDataFim(agendamentoDTO.getDataFim());
        agendamento.setTipoAgendamento(agendamentoDTO.getTipoAgendamento());
        agendamento.setStatusAgendamento(agendamentoDTO.getStatusAgendamento());
        agendamento.setMedico(medico);
        agendamento.setPaciente(paciente);
        agendamento.setUsuario(usuario);

        return agendamentoRepository.save(agendamento);

    }
}
