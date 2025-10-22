package com.example.ProjetoBackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "medico_id") 
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id") 
    private Paciente paciente;

    
}
