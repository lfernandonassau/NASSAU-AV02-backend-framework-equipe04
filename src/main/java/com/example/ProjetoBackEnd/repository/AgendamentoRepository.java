package com.example.ProjetoBackEnd.repository;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByUsuario(Usuario usuario);
    List<Agendamento> findByMedico(Medico medico);
    List<Agendamento> findByStatusAgendamento(Boolean statusAgendamento);
    List<Agendamento> findByPaciente(Paciente paciente);


    List<Agendamento> findByDataInicioAndDataFim(LocalDateTime dataInicio, LocalDateTime dataFim);
}