package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.model.Medico;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class MedicoResponse {

    private String nome;
    private String crm;
    private boolean ativo;
    private String nomeEspecialidade;

    public MedicoResponse(MedicoResponse medico) {
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.ativo = medico.isAtivo();


        if (medico.getNomeEspecialidade() != null) {
            this.nomeEspecialidade = medico.getNomeEspecialidade();
        } else {
            this.nomeEspecialidade = null;
        }
    }


    public MedicoResponse(Medico medico) {

        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.ativo = medico.isAtivo();


        if (medico.getEspecialidade() != null) {

            this.nomeEspecialidade = medico.getEspecialidade().getNome();
        } else {
            this.nomeEspecialidade = null;
        }
    }
    }


