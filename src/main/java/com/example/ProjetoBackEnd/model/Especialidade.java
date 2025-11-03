package com.example.ProjetoBackEnd.model;

import com.example.ProjetoBackEnd.dto.MedicoResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;


    @OneToMany(mappedBy = "especialidade",fetch = FetchType.EAGER)
    private List<Medico> medicos;

}