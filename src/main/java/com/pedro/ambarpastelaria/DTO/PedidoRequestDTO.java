package com.pedro.ambarpastelaria.DTO;

import java.util.List;
import jakarta.validation.constraints.Size;


public class PedidoRequestDTO {
    @Size(max = 255,message = "A Observação não pode ultrapassar 255 caracteres")
    private String observacao;
    private List<ItemPedidoDTO> itens;

    public String getObservacao() {return observacao;}
    public List <ItemPedidoDTO> getItens() {return itens;}
    public void setObservacao(String observacao){this.observacao = observacao;}
    public void setItens(List<ItemPedidoDTO> itens){this.itens = itens;}
}
