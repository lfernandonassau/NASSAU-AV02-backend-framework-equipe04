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

    @Override
    public Medico buscarMedicoPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public Medico cadastrarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico atualizarMedico(Long id, Medico medicoNovosDados) {
        
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
