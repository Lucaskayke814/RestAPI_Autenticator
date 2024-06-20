package com.example.entity;

import com.example.enums.TipoConta;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "autenticacao")
public class Usuario {

    @Id
    private String id;

    private String nomeUsuario;

    private String senha;

    private String email;

    private TipoConta tipoConta;

    public Usuario(String id, String nomeUsuario, String senha, String email, TipoConta tipoConta) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.tipoConta = tipoConta;
    }

    public Usuario() {}

    // Getters e Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
}
