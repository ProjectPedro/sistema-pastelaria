package com.pedro.ambarpastelaria.DTO;

import com.pedro.ambarpastelaria.model.FormaPagamento;
import java.time.LocalDateTime;

public class PagamentoResponseDTO {

    private Long id;
    private Long pedidoId;
    private Double valor;
    private FormaPagamento formaPagamento;
    private LocalDateTime dataPagamento;
    private Boolean aprovado;

    public Long getId(){return id;}
    public Long getPedidoId(){return pedidoId;}
    public Double getValor(){return valor;}
    public FormaPagamento getFormaPagamento(){return formaPagamento;}
    public LocalDateTime getDataPagamento(){return dataPagamento;}
    public Boolean getAprovado(){return aprovado;}

    public void setId(Long id){this.id = id;}
    public void setPedidoId(Long pedidoId){this.pedidoId = pedidoId;}
    public void setValor(Double valor){this.valor = valor;}
    public void setFormaPagamento(FormaPagamento formaPagamento){this.formaPagamento = formaPagamento;}
    public void setDataPagamento(LocalDateTime dataPagamento){this.dataPagamento = dataPagamento;}
    public void setAprovado(Boolean aprovado){this.aprovado = aprovado;}
}
