package com.example.ProjetoBackEnd.model;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Paciente;
    private String nome_Paciente;
    private String cpf_Paciente;
    private String telefone_Paciente;
    private String endereco_Paciente;
    private String email_Paciente;
    private String data_Nascimento_Paciente;
    private boolean ativo_Paciente;

    //só pra saber quem cadastrou o paciente
    @ManyToOne
    @JoinColumn(name = "id")
    private Usuario usuario;
}

// fazer o crud: Celso