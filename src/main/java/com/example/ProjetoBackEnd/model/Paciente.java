package com.example.ProjetoBackEnd.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Simplificado
    private String nome; // Simplificado
    private String cpf; // Simplificado
    private String telefone; // Simplificado
    private String endereco; // Simplificado
    private String email; // Simplificado
    private String dataNascimento; // Corrigido para CamelCase
    private boolean ativo = true; // Simplificado e com valor default

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Ajustado para evitar conflito com o 'id' do Paciente
    private Usuario usuario;
}