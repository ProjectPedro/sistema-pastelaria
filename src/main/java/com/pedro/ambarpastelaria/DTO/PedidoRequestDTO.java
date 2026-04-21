package com.pedro.ambarpastelaria.DTO;

import jakarta.validation.constraints.Size;

public class PedidoRequestDTO {
    @Size(max = 255,message = "A Observação não pode ultrapassar 255 caracteres")
    private String observacao;

    public String getObservacao()
    {
        return observacao;
    }

    public void setObservacao(String observacao)
    {
        this.observacao = observacao;
    }
}
