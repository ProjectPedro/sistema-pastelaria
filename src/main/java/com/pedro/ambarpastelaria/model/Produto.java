package com.pedro.ambarpastelaria.model;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
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
