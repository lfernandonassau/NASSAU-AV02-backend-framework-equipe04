package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String tipoAgendamento;
    private Boolean statusAgendamento;
    private String nomeMedico;
    private String nomePaciente;
    private String nomeSala;

}
