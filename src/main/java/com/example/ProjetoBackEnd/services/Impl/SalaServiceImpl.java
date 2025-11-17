package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.dto.MedicoDTO;
import com.example.ProjetoBackEnd.dto.PacienteDTO;
import com.example.ProjetoBackEnd.dto.SalaDTO;
import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.Sala;
import com.example.ProjetoBackEnd.repository.SalaRepository;
import com.example.ProjetoBackEnd.services.SalaService;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SalaServiceImpl implements SalaService {


    private  final SalaRepository salaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public void validarSala(SalaDTO sala){
        if(sala.getNome() == null || sala.getNome().trim().isEmpty()){
            throw new IllegalArgumentException("Nome da sala invalida");
        }
    }
    @Override
    @Transactional
    public Sala salvarSala(SalaDTO salaDTO){
        validarSala(salaDTO);

        Sala novaSala = new Sala();
        novaSala.setNome(salaDTO.getNome());


        if (salaDTO.getMedicoId() != null) {
            Medico medico = medicoRepository.findById(salaDTO.getMedicoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado com ID: " + salaDTO.getMedicoId()));


            novaSala.setMedico(medico);
        }


        if (salaDTO.getPacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(salaDTO.getPacienteId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com ID: " + salaDTO.getPacienteId()));


            novaSala.setPaciente(paciente);
        }

        return salaRepository.save(novaSala);
    }

    @Override
    @Transactional
    public Sala atualizarSala(SalaDTO salaDTO) {
        validarSala(salaDTO);


        if (salaDTO.getSalaId() == null) {
            throw new IllegalArgumentException("ID da sala é obrigatório para atualização.");
        }


        Sala salaExistente = salaRepository.findById(salaDTO.getSalaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada com ID: " + salaDTO.getSalaId()));


        salaExistente.setNome(salaDTO.getNome());


        if (salaDTO.getMedicoId() != null) {

            Medico medico = medicoRepository.findById(salaDTO.getMedicoId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado com ID: " + salaDTO.getMedicoId()));


            salaExistente.setMedico(medico);
        } else {
          salaExistente.setMedico(null);
        }


        if (salaDTO.getPacienteId() != null) {

            Paciente paciente = pacienteRepository.findById(salaDTO.getPacienteId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado com ID: " + salaDTO.getPacienteId()));


            salaExistente.setPaciente(paciente);
        } else {

            salaExistente.setPaciente(null);
        }


        return salaRepository.save(salaExistente);
    }

    @Override
    public Sala buscarSalaPorId(Long id){

        return salaRepository.findById(id).get();
    }

    @Override
    public void excluirSala(Long id){

        salaRepository.deleteById(id);
    }





    
}
