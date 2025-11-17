package com.example.ProjetoBackEnd.services;
import com.example.ProjetoBackEnd.dto.SalaDTO;
import com.example.ProjetoBackEnd.model.Agendamento;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Sala;
import org.springframework.stereotype.Service;

@Service
public interface SalaService {

    public Sala salvarSala(SalaDTO sala);
    public Sala atualizarSala(SalaDTO sala);
    public void excluirSala(Long id);
    public Sala buscarSalaPorId(Long id);

    

    
}
