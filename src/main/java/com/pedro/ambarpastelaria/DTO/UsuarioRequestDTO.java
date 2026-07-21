package com.pedro.ambarpastelaria.DTO;

import com.pedro.ambarpastelaria.model.Usuario;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public class UsuarioRequestDTO {
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Email(message = "Email inválido.")
    @NotBlank(message = "Email é obrigatório.")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;

    public String getNome(){return nome;}
    public String getEmail(){return email;}
    public String getSenha(){return senha;}

    public void setNome(String nome){this.nome=nome;}
    public void setEmail(String email){this.email=email;}
    public void setSenha(String senha){this.senha=senha;}
}
