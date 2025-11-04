package com.example.ProjetoBackEnd.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Date;


@Data
public class PacienteDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private String nomeUsuario;



}