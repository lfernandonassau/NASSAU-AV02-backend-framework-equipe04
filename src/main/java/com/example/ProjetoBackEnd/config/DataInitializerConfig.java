package com.example.ProjetoBackEnd.config;

import com.example.ProjetoBackEnd.model.Role;
import com.example.ProjetoBackEnd.model.Usuario;
import com.example.ProjetoBackEnd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.ProjetoBackEnd.model.Role.Role_ADMIN;

@Configuration
public class DataInitializerConfig {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            if(usuarioRepository.findByEmail("admin@admin.com")==null){
                System.out.println("criando admin");
                Usuario admin = new Usuario();
                admin.setNome("admin");
                admin.setSenha(passwordEncoder.encode("admin"));
                admin.setAtivo(true);
                admin.setRole(Role_ADMIN);
                usuarioRepository.save(admin);
                System.out.println("Usuário ADMIN criado.");

            }
        };

    }
}
