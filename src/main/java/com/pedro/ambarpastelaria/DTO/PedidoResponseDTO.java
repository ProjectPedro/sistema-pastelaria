package com.pedro.ambarpastelaria.DTO;

import com.pedro.ambarpastelaria.model.StatusPedido;
import java.time.LocalDateTime;

public class PedidoResponseDTO {

    private Long id;
    private String observacao;
    private StatusPedido statusPedido;
    private Double total;
    private LocalDateTime dataPedido;

    public Long getId() {return id;}
    public String getObservacao() {return observacao;}
    public StatusPedido getStatusPedido() {return statusPedido;}
    public Double getTotal() {return total;}
    public LocalDateTime getDataPedido() {return dataPedido;}

    public void setId(Long id) {this.id=id;}
    public void setObservacao(String observacao) {this.observacao=observacao;}
    public void setStatusPedido(StatusPedido statusPedido) {this.statusPedido=statusPedido;}
    public void setTotal(Double total) {this.total=total;}
    public void setDataPedido(LocalDateTime dataPedido) {this.dataPedido=dataPedido;}
}
