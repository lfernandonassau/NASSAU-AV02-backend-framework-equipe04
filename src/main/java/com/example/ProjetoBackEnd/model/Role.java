package com.example.ProjetoBackEnd.model;

public enum Role {
    Role_ADMIN,
    ROLE_USER;
    public String getRoleName() {
        return name();
    }
}
