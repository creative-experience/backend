package br.com.delivery.handlers.exceptions;

public class ParametroNullException extends RuntimeException {

    public ParametroNullException(String mensagem) {
        super(mensagem);
    }

    public ParametroNullException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

