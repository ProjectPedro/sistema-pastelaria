package com.pedro.ambarpastelaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PedidoStatusException extends RuntimeException {
    public PedidoStatusException(Long id) {
        super("Pedido " + id + "Não pode ter o status alterado pois já foi finalizado ou cancelado.");
    }
}
