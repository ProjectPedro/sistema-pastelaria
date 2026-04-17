package com.pedro.ambarpastelaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    @Size(max = 255)
    private String observacao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private LocalDateTime dataPedido;

    public Long getId(){return id;}
    public Double getTotal(){return total;}
    public String getObservacao(){return observacao;}
    public StatusPedido getStatus(){return status;}
    public LocalDateTime getDataPedido(){return dataPedido;}
    public void setId(Long id){this.id = id;}
    public void setTotal(Double total){this.total = total;}
    public void setObservacao(String observacao){this.observacao = observacao;}
    public void setStatus(StatusPedido status){this.status = status;}
    public void setDataPedido(LocalDateTime dataPedido){this.dataPedido = dataPedido;}
}
