package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Sala;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SalaResponse {

    private String nome;
    private String nomeMedico;
    private String nomePaciente;

    public SalaResponse(Sala sala) {
        this.nome = sala.getNome();   //maluquice escrever tudo em uma linha João >:(
        this.nomeMedico = sala.getMedico() != null ? sala.getMedico().getNome() : null;
        this.nomePaciente = sala.getPaciente() != null ? sala.getPaciente().getNome() : null;
    }
}


