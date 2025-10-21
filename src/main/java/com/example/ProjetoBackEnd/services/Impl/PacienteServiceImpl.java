package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente buscarPacientePorNome(String nome) {

        return pacienteRepository.buscaPorNome(nome);

    }

    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {

        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) {



        paciente.setEmail_Paciente(paciente.getEmail_Paciente());
        paciente.setNome_Paciente(paciente.getNome_Paciente());
        paciente.setEndereco_Paciente(paciente.getEndereco_Paciente());
        paciente.setTelefone_Paciente(paciente.getTelefone_Paciente());


        return pacienteRepository.save(paciente);
    }

    @Override
    public void removerPaciente(Long id) {

        pacienteRepository.deleteById(id);
    }
}