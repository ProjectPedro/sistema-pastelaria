package com.pedro.ambarpastelaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class PagamentoException extends RuntimeException {
    public PagamentoException(String message)
    {
        super(message);
    }
}
