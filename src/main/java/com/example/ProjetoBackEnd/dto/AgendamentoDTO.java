package com.example.ProjetoBackEnd.dto;

<<<<<<< HEAD
=======
import com.example.ProjetoBackEnd.model.Agendamento;

>>>>>>> 3a54293b064fc71585d35190430eedfd52243537
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {
<<<<<<< HEAD

=======
>>>>>>> 3a54293b064fc71585d35190430eedfd52243537
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String tipoAgendamento;
    private Boolean statusAgendamento;
<<<<<<< HEAD

    private Long usuarioId;
    private Long medicoId;
    private Long pacienteId;
}


=======
    private String nomeMedico;
    private String nomePaciente;
    private String nomeSala;

}
>>>>>>> 3a54293b064fc71585d35190430eedfd52243537

