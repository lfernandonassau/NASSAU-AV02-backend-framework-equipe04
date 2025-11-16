package com.example.ProjetoBackEnd.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import com.example.ProjetoBackEnd.model.Paciente;

@Data
@NoArgsConstructor
public class PacienteResponse {
    
    private String  nome;
    private String    telefone;
    private String  email;
    private Date dataNascimento;


    public PacienteResponse(Paciente paciente) {
        this.nome = paciente.getNome();
        this.telefone = paciente.getTelefone();
        this.email = paciente.getEmail();
        this.dataNascimento = paciente.getDataNascimento();

    }
}

