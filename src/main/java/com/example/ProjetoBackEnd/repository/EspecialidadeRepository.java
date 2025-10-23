package com.example.ProjetoBackEnd.repository;
import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.model.Medico;
import com.example.ProjetoBackEnd.model.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

     public abstract Especialidade findByNome(String nome);
    
}
