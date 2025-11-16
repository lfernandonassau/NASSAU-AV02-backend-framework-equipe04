package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.dto.PacienteDTO;
import com.example.ProjetoBackEnd.model.Especialidade;
import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Calendar;


@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public void validarPaciente(PacienteDTO paciente){
        if(paciente.getNome() == null || paciente.getNome().trim().isEmpty() ){
            throw new IllegalArgumentException("nome do Paciente invalido");
        }
        if(paciente.getCpf() == null || String.valueOf(paciente.getCpf()).length() != 11){
            throw new IllegalArgumentException("cpf do Paciente invalido");
        }
        if(paciente.getTelefone() == null || String.valueOf(paciente.getTelefone()).length() != 11){
            throw new IllegalArgumentException("telfone do Paciente invalido");
        }
        if(paciente.getEmail() == null || !paciente.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("Email invalido");
        }
        if(paciente.getDataNascimento() == null){
            throw new IllegalArgumentException("Data de nascimento do paciente invalida");

        }
        if (paciente.getDataNascimento().after(new Date())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int anoAtual = cal.get(Calendar.YEAR);

        cal.setTime(paciente.getDataNascimento());
        int anoNascimento = cal.get(Calendar.YEAR);

        int idade = anoAtual - anoNascimento;

        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }

    }

    @Override
    public Paciente buscarPacientePorNome(String nome) {

        return pacienteRepository.findByNome(nome);

    }

    @Override
    public Paciente cadastrarPaciente(PacienteDTO paciente) {
       Paciente paciente1 = conversaoDTO(paciente);

        validarPaciente(paciente);
        return pacienteRepository.save(paciente1);
    }

    public Paciente atualizarPaciente(Long id, PacienteDTO pacienteNovosDados) {
        validarPaciente(pacienteNovosDados);

        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow();

        if()

        pacienteExistente.setEmail(pacienteNovosDados.getEmail());
        pacienteExistente.setNome(pacienteNovosDados.getNome());
        pacienteExistente.setEndereco(pacienteNovosDados.getEndereco());
        pacienteExistente.setTelefone(pacienteNovosDados.getTelefone());
        pacienteExistente.setCpf(pacienteNovosDados.getCpf());
        pacienteExistente.setDataNascimento(pacienteNovosDados.getDataNascimento());



        return pacienteRepository.save(pacienteExistente);
    }
    @Override
    public void removerPaciente(Long id) {

        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente conversaoDTO(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDTO.getNome());
        paciente.setTelefone((pacienteDTO.getTelefone()));
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setEndereco(pacienteDTO.getEndereco());



        return pacienteRepository.save(paciente);
    }


}
