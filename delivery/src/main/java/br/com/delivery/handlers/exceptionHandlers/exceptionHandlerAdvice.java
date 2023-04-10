package br.com.delivery.handlers.exceptionHandlers;

import br.com.delivery.model.response.errorResponse;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class exceptionHandlerAdvice {

    protected final static String DETAIL = "Detail: ";

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<errorResponse> conflict(DataIntegrityViolationException ex) {
        String message = getMostSpecificMessage(ex);

        return new ResponseEntity<>(new errorResponse(false, message), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<errorResponse> accessDenied(AccessDeniedException ex) {
        String message = ex.getMessage();

        return new ResponseEntity<>(new errorResponse(false, message), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<errorResponse> validationException(ValidationException ex) {
        String message = ex.getMessage();

        return new ResponseEntity<>(new errorResponse(false, message), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<errorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ex.printStackTrace();

        String message = ex.getMessage();
        return new ResponseEntity<>(new errorResponse(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<errorResponse> unhandledExceptions(Exception ex) {
        String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();

        ex.printStackTrace();

        return new ResponseEntity<>(new errorResponse(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getMostSpecificMessage(DataIntegrityViolationException ex) {
        String message = NestedExceptionUtils.getMostSpecificCause(ex).getMessage();

        if (message.contains(DETAIL)) {
            message = message.substring(message.indexOf(DETAIL) + DETAIL.length());
        }
        return message;
    }
}

