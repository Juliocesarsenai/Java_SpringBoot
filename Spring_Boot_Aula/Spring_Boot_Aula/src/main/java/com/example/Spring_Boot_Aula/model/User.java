package com.example.Spring_Boot_Aula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;


    public User() {
    }

    public User(Long id, String name, String email, String senha) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public @NotBlank(message = "Nome é obrigatório") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Nome é obrigatório") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") String senha) {
        this.senha = senha;
    }
}
