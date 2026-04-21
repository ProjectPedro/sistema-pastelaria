package com.pedro.ambarpastelaria.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(Long id)
    {
        super("Pedido com id " + id + " não encontrado.");
    }
}
