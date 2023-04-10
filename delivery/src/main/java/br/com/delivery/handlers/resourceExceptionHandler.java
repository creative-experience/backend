package br.com.delivery.handlers;

import br.com.delivery.handlers.exceptionHandlers.errorModel;
import br.com.delivery.handlers.exceptions.*;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@AllArgsConstructor
public class resourceExceptionHandler {

    protected final String URL = "http://localhost:8080/erros/";

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<errorModel> handlerRecursoNaoEncontradoException(RecursoNaoEncontradoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new errorModel(e.getMessage(), 404L, 404L, System.currentTimeMillis(), URL + "404"));
    }

    @ExceptionHandler(ParametroInvalidoException.class)
    public ResponseEntity<errorModel> handlerParametroInvalidoException(ParametroInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new errorModel(e.getMessage(), 406L, 406L, System.currentTimeMillis(), URL + "406"));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<errorModel> handlerConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new errorModel(e.getMessage(), 409L, 409L, System.currentTimeMillis(), URL + "409"));
    }

    @ExceptionHandler(ParametroNullException.class)
    public ResponseEntity<errorModel> handlerParametroNullException(ParametroNullException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new errorModel(e.getMessage(), 400L, 400L, System.currentTimeMillis(), URL + "400"));
    }

    @ExceptionHandler(CpfInvalidoException.class)
    public ResponseEntity<errorModel> handlerCpfInvalidoException(CpfInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new errorModel(e.getMessage(), 400L, 400L, System.currentTimeMillis(), URL + "400"));
    }

    @ExceptionHandler(TamanhoInvalidoException.class)
    public ResponseEntity<errorModel> handlerTamanhoInvalidoException(TamanhoInvalidoException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new errorModel(e.getMessage(), 400L, 400L, System.currentTimeMillis(), URL + "400"));
    }
}