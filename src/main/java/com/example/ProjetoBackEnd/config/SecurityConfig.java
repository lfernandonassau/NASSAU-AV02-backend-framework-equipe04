package com.example.ProjetoBackEnd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // 1. Permite acesso a endpoints públicos
                .requestMatchers("/public/**").permitAll()
                
                .requestMatchers(HttpMethod.POST, "/api/especialidades/cadastrarEspecialidade").permitAll()
                .requestMatchers(HttpMethod.GET, "/especialidades").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/pacientes").authenticated()
                .anyRequest().authenticated()
            );
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        
        return config.getAuthenticationManager();
    }
    

}