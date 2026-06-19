package com.pedro.ambarpastelaria.DTO;

import java.util.List;

public class ItemPedidoDTO {
    private Long produtoId;
    private Integer quantidade;
    private String observacao;

    public Long getProdutoId(){return produtoId;}
    public Integer getQuantidade(){return quantidade;}
    public String getObservacao(){return observacao;}

    public void setProdutoId(Long produtoId){this.produtoId = produtoId;}
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}
    public void setObservacao(String observacao){this.observacao = observacao;}
}
