package com.pedro.ambarpastelaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer quantidade;

    @Positive
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


    public Long getId() {return id;}
    public Integer getQuantidade() {return quantidade;}
    public Double getPrecoUnitario() {return precoUnitario;}
    public Pedido getPedido(){return pedido;}
    public Produto getProduto(){return produto;}
    public void setId(Long id){this.id = id;}
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}
    public void setPrecoUnitario(Double precoUnitario){this.precoUnitario = precoUnitario;}
    public void setPedido(Pedido pedido){this.pedido = pedido;}
    public void setProduto(Produto produto){this.produto = produto;}
}
