package com.example.ProjetoBackEnd.model;

public enum Role {
    ADMIN,
    USER;

    public String getRoleName() {
        return "ROLE_" + this.name(); // Retorna ROLE_ADMIN ou ROLE_USER
    }
}
