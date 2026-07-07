package com.pedro.ambarpastelaria.DTO;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;


public class PedidoRequestDTO {
    @Size(max = 255,message = "A Observação não pode ultrapassar 255 caracteres")
    private String observacao;
    @NotNull
    @Valid
    private List<ItemPedidoDTO> itens;

    public String getObservacao() {return observacao;}
    public List <ItemPedidoDTO> getItens() {return itens;}
    public void setObservacao(String observacao){this.observacao = observacao;}
    public void setItens(List<ItemPedidoDTO> itens){this.itens = itens;}
}
