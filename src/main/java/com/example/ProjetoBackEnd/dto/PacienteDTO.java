package com.example.ProjetoBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {

    private String nome;
    private Long cpf;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;




}