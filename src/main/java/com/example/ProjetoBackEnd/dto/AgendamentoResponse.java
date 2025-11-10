package com.example.ProjetoBackEnd.dto;


import java.time.LocalDateTime;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class AgendamentoResponse {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String tipoAgendamento;
    private Boolean statusAgendamento;
    private String nomeMedico;
    private String nomePaciente;
    private String nomeSala;





    public AgendamentoResponse(AgendamentoResponse agendamento){
        this.dataInicio = agendamento.getDataInicio();
        this.dataFim = agendamento.getDataFim();
        this.tipoAgendamento = agendamento.getTipoAgendamento();
        this.statusAgendamento = agendamento.getStatusAgendamento();

        if(agendamento.getNomeMedico() != null){

            this.nomeMedico = agendamento.getNomeMedico();
        }
        else{
            this.nomeMedico = null;
        }


    }

    public AgendamentoResponse(Agendamento agendamento){
        this.dataInicio = agendamento.getDataInicio();
        this.dataFim = agendamento.getDataFim();
        this.tipoAgendamento = agendamento.getTipoAgendamento();
        this.statusAgendamento = agendamento.getStatusAgendamento();

        if(agendamento.getMedico() != null){

            this.nomeMedico = String.valueOf(agendamento.getMedico());
        }
        else{
            this.nomeMedico = null;
        }


    }


}
