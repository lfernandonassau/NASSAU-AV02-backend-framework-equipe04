package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
    private String nome;

    private String crm;

    private String nomeEspecialidade;

    private boolean ativo;

}
