package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.dto.EspecialidadeDTO;
import com.example.ProjetoBackEnd.model.Especialidade;

public interface EspecialidadeService {

    public Especialidade buscarEspecialidade(String nome);
    public Especialidade cadastrarEspecialidade(EspecialidadeDTO especialidadeDTO);
    public Especialidade atualizarEspecialidade(Long id, EspecialidadeDTO especialidadeDTO); //Atualizar
    public void excluirEspecialidade(Long id);
    public Especialidade conversaoDTO(EspecialidadeDTO especialidadeDTO);
    
}
