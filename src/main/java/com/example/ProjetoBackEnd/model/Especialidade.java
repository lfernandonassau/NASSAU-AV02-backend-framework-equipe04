package com.example.ProjetoBackEnd.model;


import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@Data
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_especialidade;
    private String nome_especialidade;
    private String descricao_especialidade;

    @OneToMany(mappedBy = "especialidade")
    private List<Medico> medicos;
    
    
}

// fazer o crud: jão