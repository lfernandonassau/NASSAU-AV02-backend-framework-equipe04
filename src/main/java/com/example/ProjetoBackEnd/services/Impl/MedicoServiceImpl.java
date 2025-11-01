package com.example.ProjetoBackEnd.services.Impl;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import com.example.ProjetoBackEnd.services.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.*;;


@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;


    public void validarMedico(Medico medico){
        if(medico.getNome() == null || medico.getNome().trim().isEmpty()){
            throw new IllegalArgumentException("Nome do medico invalido");
        }
        if (medico.getCrm() == null) {
            throw new IllegalArgumentException("CRM inválido");
        }
        if(medico.getTelefone() == null || medico.getTelefone().toString().length() <11){
            throw new IllegalArgumentException("Telefone invalido");
        }

    }

    @Override
    public Medico buscarMedicoPorId(Long id) {

        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public Medico cadastrarMedico(Medico medico) {
        validarMedico(medico);
        return medicoRepository.save(medico);
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
}
