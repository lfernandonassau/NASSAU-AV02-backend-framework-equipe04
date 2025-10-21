package com.example.ProjetoBackEnd.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private String tipoAgendamento;
    private Boolean statusAgendamento;

    @ManyToOne
    @JoinColumn(name = "usuario_id") 
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "medico_id") 
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id") 
    private Paciente paciente;
}