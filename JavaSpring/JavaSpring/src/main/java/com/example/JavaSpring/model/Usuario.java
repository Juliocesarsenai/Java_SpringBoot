package com.example.JavaSpring.model;

import jakarta.persistence.*;

@Entity
@Table(name="tab_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    private String cpf;
    private String rg;
    private String senha;

    public Usuario() {
    }

    public Usuario(String username, String cpf, String rg,String senha) {

        this.username = username;
        this.cpf = cpf;
        this.rg = rg;
        this.senha=senha;
    }

    public Long getId() {
        return id;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(){
        this.senha=senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Usuario" +
                "id" + id +
                "nome" + username  +
                "cpf" + cpf  +
                "rg" + rg +
                "senha" + senha
                ;
    }
}
