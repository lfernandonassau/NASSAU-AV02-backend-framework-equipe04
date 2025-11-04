package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Paciente;

public class PacienteResponse {
    String  nome;
    Long    telefone;
    String  email;

   String  nomeUsuario;

    public PacienteResponse(Paciente paciente) {

    }
}

