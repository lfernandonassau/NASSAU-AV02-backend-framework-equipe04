package com.example.ProjetoBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProjetoBackEnd.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}