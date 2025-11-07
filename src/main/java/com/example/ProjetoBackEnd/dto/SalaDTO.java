package com.example.ProjetoBackEnd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {

    private String nome;
    private Long medicoId;
    private Long pacienteId;
}


