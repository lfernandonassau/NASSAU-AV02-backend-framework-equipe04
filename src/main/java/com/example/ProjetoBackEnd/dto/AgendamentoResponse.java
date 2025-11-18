package com.example.ProjetoBackEnd.dto;

import com.example.ProjetoBackEnd.model.Agendamento;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AgendamentoResponse {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String tipoAgendamento;
    private Boolean statusAgendamento;

    private String nomeUsuario;
    private String nomeMedico;
    private String nomePaciente;
    private String nomeSala;

    public AgendamentoResponse(Agendamento agendamento) {
        this.dataInicio = agendamento.getDataInicio();
        this.dataFim = agendamento.getDataFim();
        this.tipoAgendamento = agendamento.getTipoAgendamento();
        this.statusAgendamento = agendamento.getStatusAgendamento();

        this.nomeUsuario  = agendamento.getUsuario()  != null ? agendamento.getUsuario().getNome()  : null;
        this.nomeMedico   = agendamento.getMedico()   != null ? agendamento.getMedico().getNome()   : null;
        this.nomePaciente = agendamento.getPaciente() != null ? agendamento.getPaciente().getNome() : null;
        this.nomeSala     = agendamento.getSala()     != null ? agendamento.getSala().getNome()     : null;
    }

    public AgendamentoResponse(int id, Agendamento salvo) {
    }
}



