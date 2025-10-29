package com.example.ProjetoBackEnd.dto;

import lombok.Data;


@Data
public class LoginRequest {
    private String email;
    private String senha;
}
