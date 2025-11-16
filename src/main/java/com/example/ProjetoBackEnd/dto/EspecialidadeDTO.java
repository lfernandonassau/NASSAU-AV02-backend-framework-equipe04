package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Especialidade;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EspecialidadeDTO {
    private String nomeEspecialidade;
    private String descricao;


    public EspecialidadeDTO(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;

    }

    public EspecialidadeDTO(Especialidade especialidade) {
    }
}