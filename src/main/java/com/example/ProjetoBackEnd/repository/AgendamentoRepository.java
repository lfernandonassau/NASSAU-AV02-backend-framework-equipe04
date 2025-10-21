package com.example.ProjetoBackEnd.repository;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    public List<Agendamento> findByUsuario(Usuario usuario);
    public List<Agendamento> findByMedico(Medico medico);
    public List<Agendamento> findByStatus(Boolean status);
    public List<Agendamento>  findByPaciente(Paciente paciente);
    public List<Agendamento> verificarHorario(LocalDateTime dataInicio, LocalDateTime dataFim);
    public List<Agendamento> verificaHorarioPorMedico(LocalDateTime dataInicio, LocalDateTime dataFim, Medico medico);
}
