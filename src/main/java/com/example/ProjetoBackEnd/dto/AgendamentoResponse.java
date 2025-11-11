package com.example.ProjetoBackEnd.dto;

<<<<<<< HEAD
import com.example.ProjetoBackEnd.model.Agendamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
=======

import java.time.LocalDateTime;

import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
>>>>>>> 3a54293b064fc71585d35190430eedfd52243537

@Data
@NoArgsConstructor
public class AgendamentoResponse {
<<<<<<< HEAD

=======
>>>>>>> 3a54293b064fc71585d35190430eedfd52243537
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String tipoAgendamento;
    private Boolean statusAgendamento;
<<<<<<< HEAD

    private String nomeUsuario;
    private String nomeMedico;
    private String nomePaciente;

    public AgendamentoResponse(Agendamento agendamento) {
        this.dataInicio = agendamento.getDataInicio();
        this.dataFim = agendamento.getDataFim();
        this.tipoAgendamento = agendamento.getTipoAgendamento();
        this.statusAgendamento = agendamento.getStatusAgendamento(); //bizarro

        this.nomeUsuario = agendamento.getUsuario() != null ? agendamento.getUsuario().getNome() : null;
        this.nomeMedico = agendamento.getMedico() != null ? agendamento.getMedico().getNome() : null;
        this.nomePaciente = agendamento.getPaciente() != null ? agendamento.getPaciente().getNome() : null;
    }
}


=======
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
>>>>>>> 3a54293b064fc71585d35190430eedfd52243537
