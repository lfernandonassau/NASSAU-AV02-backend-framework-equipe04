package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.repository.PacienteRepository;

public interface PacienteService {

    public Paciente buscarPacientePorNome(String nome);
    public Paciente cadastrarPaciente(Paciente paciente);
    public Paciente atualizarPaciente(Paciente paciente);
    public void removerPaciente(Long id);


}