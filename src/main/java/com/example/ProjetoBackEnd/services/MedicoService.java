package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Medico;

public interface MedicoService {

    public Medico buscarMedicoPorId(Long id);
    public Medico cadastrarMedico(Medico medico);
    public Medico atualizarMedico(Long id, Medico medico);
    public void deletarMedico(Long id);
    
}