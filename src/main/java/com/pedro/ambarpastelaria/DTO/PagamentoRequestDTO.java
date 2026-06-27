package com.pedro.ambarpastelaria.DTO;

import com.pedro.ambarpastelaria.model.FormaPagamento;
import jakarta.validation.constraints.NotNull;

public class PagamentoRequestDTO {

    @NotNull(message = "Pedido é obrigatório")
    private Long pedidoId;
    @NotNull(message = "Forma de Pagamento é obrigatória")
    private FormaPagamento formaPagamento;

    public Long getPedidoId(){return pedidoId;}
    public FormaPagamento getFormaPagamento(){return formaPagamento;}

    public void setPedidoId(){this.pedidoId = pedidoId;}
    public void setFormaPagamento(){this.formaPagamento = formaPagamento;}
}
