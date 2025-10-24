package com.example.ProjetoBackEnd.services.Impl;

import com.example.ProjetoBackEnd.model.Paciente;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.PacienteRepository;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import com.example.ProjetoBackEnd.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;



@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Paciente buscarPacientePorNome(String nome) {

        return pacienteRepository.findByNome(nome);

    }

    @Override
    public Paciente cadastrarPaciente(Paciente paciente) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = principal.toString();

        Usuario usuarioLogado = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Erro: Usuário logado não encontrado no sistema."));

                    paciente.setUsuario(usuarioLogado);
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizarPaciente(Long id, Paciente pacienteNovosDados) {


        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow();


        pacienteExistente.setEmail(pacienteNovosDados.getEmail());
        pacienteExistente.setNome(pacienteNovosDados.getNome());
        pacienteExistente.setEndereco(pacienteNovosDados.getEndereco());
        pacienteExistente.setTelefone(pacienteNovosDados.getTelefone());


        return pacienteRepository.save(pacienteExistente);
    }
    @Override
    public void removerPaciente(Long id) {

        pacienteRepository.deleteById(id);
    }
}