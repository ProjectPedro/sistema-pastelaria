package com.pedro.ambarpastelaria.DTO;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ItemPedidoDTO {
    @NotNull(message = "Produto é obrigatório")
    private Long produtoId;
    @NotNull(message = "Quantidade é obrigatório")
    @Positive(message = "Quantidade deve ser maior que Zero")
    private Integer quantidade;
    private String observacao;

    public Long getProdutoId(){return produtoId;}
    public Integer getQuantidade(){return quantidade;}
    public String getObservacao(){return observacao;}

    public void setProdutoId(Long produtoId){this.produtoId = produtoId;}
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}
    public void setObservacao(String observacao){this.observacao = observacao;}
}
