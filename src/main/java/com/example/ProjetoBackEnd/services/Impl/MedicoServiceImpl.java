package com.example.ProjetoBackEnd.services.Impl;
import com.example.ProjetoBackEnd.dto.MedicoDTO;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.services.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.*;
import org.springframework.web.server.ResponseStatusException;;


@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;


    public void validarMedico(Medico medico) {
        if (medico.getNome() == null || medico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do medico invalido");
        }
        if (medico.getCrm() == null) {
            throw new IllegalArgumentException("CRM inválido");
        }
        if (medico.getTelefone() == null || medico.getTelefone().toString().length() < 11) {
            throw new IllegalArgumentException("Telefone invalido");
        }

    }

    @Override
    public Medico buscarMedicoPorId(Long id) {

        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public Medico cadastrarMedico(MedicoDTO medicoDTO) {

        Especialidade especialidade = especialidadeRepository.findByNome(medicoDTO.getNomeEspecialidade());

        Medico novoMedico = new Medico();


        novoMedico.setNome(medicoDTO.getNome());
        novoMedico.setCrm(medicoDTO.getCrm());


        novoMedico.setAtivo(true);


        novoMedico.setEspecialidade(especialidade);


        return medicoRepository.save(novoMedico);
    }


    @Override
    public Medico atualizarMedico(Long id, Medico medicoNovosDados) {
        validarMedico(medicoNovosDados);

        Medico medicoExistente = medicoRepository.findById(id).orElseThrow();

        medicoExistente.setNome(medicoNovosDados.getNome());
        medicoExistente.setCrm(medicoNovosDados.getCrm());
        medicoExistente.setTelefone(medicoNovosDados.getTelefone());
        medicoExistente.setEspecialidade(medicoNovosDados.getEspecialidade());
        medicoExistente.setAgendamentos(medicoNovosDados.getAgendamentos());

        return medicoRepository.save(medicoExistente);
    }

    @Override
    public void deletarMedico(Long id) {

        medicoRepository.deleteById(id);
    }

    @Override
    public Medico conversaoDTO(MedicoDTO medicoDTO) {
        String nomeeEspecialidade = medicoDTO.getNomeEspecialidade();
        Especialidade especialidade = especialidadeRepository.findByNome(nomeeEspecialidade);
        if (especialidade == null) {
            throw new RuntimeException("Especialidade" + nomeeEspecialidade + "não encontrada");
        }
            Medico medico = new Medico();
            medico.setNome(medicoDTO.getNome());
            medico.setCrm(medicoDTO.getCrm());
            medico.setAtivo(medicoDTO.isAtivo());
            medico.setEspecialidade(especialidade);

            return medicoRepository.save(medico);



    }
}

