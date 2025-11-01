package com.example.ProjetoBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String crm;
    private Long telefone;
    private boolean ativo = true; 

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medico")
    private List<Agendamento> agendamentos;
}