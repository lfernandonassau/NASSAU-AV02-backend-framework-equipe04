package com.example.ProjetoBackEnd.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProjetoBackEnd.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}