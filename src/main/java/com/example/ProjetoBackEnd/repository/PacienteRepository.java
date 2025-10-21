package com.example.ProjetoBackEnd.repository;
import com.example.ProjetoBackEnd.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    public Paciente buscaPorNome(String nome_Paciente);
}