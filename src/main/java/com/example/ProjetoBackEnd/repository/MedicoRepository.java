package com.example.ProjetoBackEnd.repository;

import com.example.ProjetoBackEnd.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProjetoBackEnd.model.Medico;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long>{


}