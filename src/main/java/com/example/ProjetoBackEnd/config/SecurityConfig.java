package com.example.ProjetoBackEnd.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth ->auth.requestMatchers("/public/**").permitAll().
                requestMatchers(HttpMethod.POST, "api/pacientes").authenticated().anyRequest().authenticated());
        return http.build();


    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return authenticationManager();
    }


    /*
     * Quando a gente for reativar a segurança a gente muda o:
     * .anyRequest().permitAll()
     * .requestMatchers("/public/**").permitAll().anyRequest().authenticated()
     */

}