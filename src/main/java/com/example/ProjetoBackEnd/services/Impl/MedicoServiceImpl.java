package com.example.ProjetoBackEnd.services.Impl;
import com.example.ProjetoBackEnd.dto.MedicoDTO;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.services.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    public void validarMedico(MedicoDTO medico) {
        if (medico.getNome() == null || medico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do medico invalido");
        }
        if (medico.getCrm() == null) {
            throw new IllegalArgumentException("CRM inválido");
        }


    }

    @Override
    public Medico buscarMedicoPorId(Long id) {

        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public Medico cadastrarMedico(MedicoDTO medicoDTO) {
        validarMedico(medicoDTO);

        Especialidade especialidade = especialidadeRepository.findByNome(medicoDTO.getNomeEspecialidade());

        Medico novoMedico = new Medico();


        novoMedico.setNome(medicoDTO.getNome());
        novoMedico.setCrm(medicoDTO.getCrm());


        novoMedico.setAtivo(true);


        novoMedico.setEspecialidade(especialidade);


        return medicoRepository.save(novoMedico);
    }


    @Override
    public Medico atualizarMedico(Long id, MedicoDTO medico) {
        validarMedico(medico);

        Medico medicoExistente = medicoRepository.findById(id).orElseThrow();


        medicoExistente.setNome(medico.getNome());
        medicoExistente.setCrm(medico.getCrm());
        medicoExistente.setEspecialidade(especialidadeRepository.findByNome(medico.getNomeEspecialidade()));
        medicoExistente.setAtivo(medico.isAtivo());

        medicoExistente.setAgendamentos((List<Agendamento>) medico.getAgendamento());

        return medicoRepository.save(medicoExistente);
    }

    @Override
    public void deletarMedico(Long id) {

        medicoRepository.deleteById(id);
    }


}

