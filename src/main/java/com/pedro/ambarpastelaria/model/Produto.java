package com.pedro.ambarpastelaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome não pode estar vazio.")
    private String nome;
    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero)")
    private double preco;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Long getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public String getDescricao(){
        return descricao;
    }
    public Categoria getCategoria(){
        return categoria;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
}
