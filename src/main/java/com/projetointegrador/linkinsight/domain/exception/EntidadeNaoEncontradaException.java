package com.projetointegrador.linkinsight.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends NegocioException{

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }

}
