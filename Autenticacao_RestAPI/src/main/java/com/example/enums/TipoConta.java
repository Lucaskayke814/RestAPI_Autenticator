package com.example.enums;

public enum TipoConta {

    ADMIN("Administrador"),
    MOD("Moderador"),
    USER("Usuário Comum");

    private final String tipoConta;

    TipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
