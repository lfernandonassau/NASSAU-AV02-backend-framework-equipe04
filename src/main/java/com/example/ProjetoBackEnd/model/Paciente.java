package com.example.ProjetoBackEnd.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Simplificado
    private String nome; // Simplificado
    private Long cpf; // Simplificado
    private Long telefone; // Simplificado
    private String endereco; // Simplificado
    private String email; // Simplificado
    private Date dataNascimento; // Corrigido para CamelCase
    private boolean ativo = true; // Simplificado e com valor default

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Ajustado para evitar conflito com o 'id' do Paciente
    private Usuario usuario;
}