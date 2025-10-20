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
    private Long id_Agendamento;
    private LocalDateTime data_hora_Agendamento;
    private String tipo_Agendamento; //consulta / exame(de prostata, sangue etc)
    private String status_Agendamento; //confirmado / cancelado

    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_Medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_Paciente")
    private Paciente paciente;

    
}

// fazer o crud: Celso