package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Especialidade;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class EspecialidadeResponse {
    private String nomeEspecialidade;
    private List<MedicoResponse> medicos;

    public EspecialidadeResponse(Especialidade especialidade) {
        this.nomeEspecialidade = especialidade.getNome();
        List<MedicoResponse> medicos = especialidade.getMedicos().stream().map(MedicoResponse::new).collect(Collectors.toList());

        if(medicos != null) {
            this.medicos= medicos.stream()
                    .map(MedicoResponse::new)
                    .collect(Collectors.toList());
        } else{
            this.medicos = new ArrayList<>();
        }

    }


}
