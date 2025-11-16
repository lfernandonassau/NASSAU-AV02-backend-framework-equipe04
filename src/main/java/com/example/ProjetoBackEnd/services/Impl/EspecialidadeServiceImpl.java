package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.repository.EspecialidadeRepository;
import com.example.ProjetoBackEnd.services.EspecialidadeService;
import com.example.ProjetoBackEnd.repository.MedicoRepository;
import org.springframework.web.server.ResponseStatusException;
import com.example.ProjetoBackEnd.dto.EspecialidadeDTO;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public void validarEspecialidade(EspecialidadeDTO especialidade){
        if(especialidade.getNomeEspecialidade() == null){
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
    public Especialidade cadastrarEspecialidade(EspecialidadeDTO especialidadeDTO){
        validarEspecialidade(especialidadeDTO);
        Especialidade especialidade = conversaoDTO(especialidadeDTO);
        return this.especialidadeRepository.save(especialidade);
    }

    @Override
    public Especialidade atualizarEspecialidade(Long id, EspecialidadeDTO especialidadeDTO) {
        validarEspecialidade(especialidadeDTO);

        Especialidade especialidadeExistente = especialidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade com ID " + id + " não encontrada!"));



        if (especialidadeDTO.getNomeEspecialidade() != null) {
            especialidadeExistente.setNome(especialidadeDTO.getNomeEspecialidade());
        }

        if (especialidadeDTO.getDescricao() != null) {
            especialidadeExistente.setDescricao(especialidadeDTO.getDescricao());
        }


        return especialidadeRepository.save(especialidadeExistente);
    }

    @Override
    public void excluirEspecialidade(Long id){
        especialidadeRepository.deleteById(id);
    }

    @Override
    public Especialidade conversaoDTO(EspecialidadeDTO especialidadeDTO) {

        Especialidade e= new Especialidade();
        e.setNome(especialidadeDTO.getNomeEspecialidade());
        e.setDescricao(especialidadeDTO.getDescricao());

        return especialidadeRepository.save(e);



    }

}
