package com.example.ProjetoBackEnd.services.Impl;

import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.Sala;
import com.example.ProjetoBackEnd.repository.SalaRepository;
import com.example.ProjetoBackEnd.services.SalaService;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;


@Service
public class SalaServiceImpl implements SalaService {

    private  final SalaRepository salaRepository;
    public SalaServiceImpl(SalaRepository salaRepository){
        this.salaRepository = salaRepository;

    }

    @Override
    public Sala salvarSala(Sala sala){
        return this.salaRepository.save(sala);
    }

    @Override
    public Sala atualizarSala(Sala room){
        room.setNome(room.getNome());
        room.setMedico(room.getMedico());
        room.setPaciente(room.getPaciente());
        return salaRepository.save(room);
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
