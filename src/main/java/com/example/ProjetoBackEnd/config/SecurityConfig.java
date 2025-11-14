    package com.example.ProjetoBackEnd.config;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.builders.WebSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        @Autowired
        private SecurityFilter securityFilter;


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            // 1. Permite acesso a endpoints públicos
                            .requestMatchers("/public/**").permitAll()

                            .requestMatchers(HttpMethod.POST, "/api/cadastrarEspecialidade").authenticated()
                            .requestMatchers(HttpMethod.GET, "/api/buscarEspecialidade/{nome}").authenticated()
                            .requestMatchers(HttpMethod.PUT, "/api/atualizarEspecialidade").authenticated()
                            .requestMatchers(HttpMethod.DELETE, "/api/excluirEspecialidade/{id}").authenticated()

                            .requestMatchers(HttpMethod.POST, "/api/salvarpaciente").authenticated()
                            .requestMatchers(HttpMethod.GET, "/api/buscarPaciente/{nome}").authenticated()
                            .requestMatchers(HttpMethod.GET, "/api/buscarPaciente/{id}").authenticated()
                            .requestMatchers(HttpMethod.PUT,"/api/atualizarcadastropaciente").authenticated()
                            .requestMatchers(HttpMethod.DELETE,"/api/deletaroaciente/{id}").authenticated()

                            .requestMatchers(HttpMethod.GET, "/usuarios/buscar/{id}").authenticated()
                            .requestMatchers(HttpMethod.PUT, "/usuarios/atualizaruser").authenticated()

                            .requestMatchers(HttpMethod.POST,"/usuarios/salvar").authenticated()
                            .requestMatchers(HttpMethod.DELETE,"/usuarios/deletaruser").hasRole("ADMIN")

                            .requestMatchers(HttpMethod.POST,"/api/medico/cadastrar").authenticated()
                            .requestMatchers(HttpMethod.DELETE,"/api/medico/deletar/{id}").authenticated()
                            .requestMatchers(HttpMethod.PUT,"/api/medico/atualizar/{id}").authenticated()
                            .requestMatchers(HttpMethod.GET,"/api/medico/buscar/{id}").authenticated()

                            .requestMatchers(HttpMethod.GET, "/api/salas/buscarSalaPorId/{id}").authenticated()
                            .requestMatchers(HttpMethod.POST, "/api/salas/salvarSala").authenticated()
                            .requestMatchers(HttpMethod.PUT, "/api/salas/atualizarSala").authenticated()
                            .requestMatchers(HttpMethod.DELETE, "/api/salas/excluirSala/{id}").authenticated()

                            .requestMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
                            .requestMatchers(HttpMethod.POST, "/usuarios/forgot-password").permitAll()
                            .requestMatchers(HttpMethod.POST, "/usuarios/reset-password").permitAll()
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PATCH, "/admin/desativar/{id}").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PATCH, "/admin/ativar/{id}").hasRole("ADMIN")

                            .anyRequest().authenticated()
                    )

                    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)


                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))


                    .build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

            return config.getAuthenticationManager();
        }


        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }


    }