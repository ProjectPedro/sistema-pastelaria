package com.pedro.ambarpastelaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfil;

    public Long getId() {return id;}

    public String getNome() {return nome;}

    public String getEmail() {return email;}

    public String getSenha() {return senha;}

    public PerfilUsuario getPerfil() {return perfil;}

    public void setId(Long id) {this.id = id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setEmail(String email) {this.email = email;}

    public void setSenha(String senha) {this.senha = senha;}

    public void setPerfil(PerfilUsuario perfil) {this.perfil = perfil;}
}
