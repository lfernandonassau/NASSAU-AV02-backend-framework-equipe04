package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.dto.MedicoDTO;
import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.model.Medico;

public interface MedicoService {

    public Medico buscarMedicoPorId(Long id);
    public Medico cadastrarMedico(MedicoDTO medicoDTO);
    public Medico atualizarMedico(Long id, MedicoDTO medico);
    public void deletarMedico(Long id);


    
}