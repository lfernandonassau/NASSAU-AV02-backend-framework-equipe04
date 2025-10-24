package com.example.ProjetoBackEnd.services;

import com.example.ProjetoBackEnd.model.Especialidade;

public interface EspecialidadeService {

    public Especialidade buscarEspecialidade(String nome);
    public Especialidade cadastrarEspecialidade(Especialidade especialidade);
    public Especialidade salvarEspecialidade(Long id, Especialidade especialidadeNovosDados); //Atualizar
    public void excluirEspecialidade(Long id);
    
}
