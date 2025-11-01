package com.example.ProjetoBackEnd.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.services.EspecialidadeService;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    public void validarEspecialidade(Especialidade especialidade){
        if(especialidade.getNome() == null){
            throw new IllegalArgumentException("nome da especialidade invalida");
        }
        if(especialidade.getDescricao() == null){
            throw new IllegalArgumentException("Descreva a especialidade");
        }
    }

    @Override
    public Especialidade buscarEspecialidade(String nome){

        return especialidadeRepository.findByNome(nome);

    }
    
    @Override
    public Especialidade cadastrarEspecialidade(Especialidade especialidade){
        validarEspecialidade(especialidade);
        return this.especialidadeRepository.save(especialidade);
    }

    @Override
    public Especialidade salvarEspecialidade(Long id, Especialidade especialidadeNovosDados){
        validarEspecialidade(especialidadeNovosDados);
        Especialidade especialidadeExistente = especialidadeRepository.findById(id).orElseThrow();

        especialidadeExistente.setNome(especialidadeNovosDados.getNome());
        especialidadeExistente.setDescricao(especialidadeNovosDados.getDescricao());
        especialidadeExistente.setMedicos(especialidadeNovosDados.getMedicos());

        return especialidadeRepository.save(especialidadeExistente);
    }

    @Override
    public void excluirEspecialidade(Long id){
        especialidadeRepository.deleteById(id);
    }

}
