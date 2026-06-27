package com.pedro.ambarpastelaria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    private Double valor;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private LocalDateTime dataPagamento;
    private Boolean aprovado = false;

    public Long getId(){return id;}
    public Pedido getPedido(){return pedido;}
    public Double getValor(){return valor;}
    public FormaPagamento getFormaPagamento(){return formaPagamento;}
    public LocalDateTime getDataPagamento(){return dataPagamento;}
    public Boolean getAprovado(){return aprovado;}

    public void setId(Long id){this.id = id;}
    public void setPedido(Pedido pedido){this.pedido = pedido;}
    public void setValor(Double valor){this.valor = valor;}
    public void setFormaPagamento(FormaPagamento formaPagamento){this.formaPagamento = formaPagamento;}
    public void setDataPagamento(LocalDateTime dataPagamento){this.dataPagamento = dataPagamento;}
    public void setAprovado(Boolean aprovado){this.aprovado = aprovado;}
}
