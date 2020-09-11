package challenge.advice;

import challenge.advice.error.ApiError;
import challenge.advice.error.ApiFieldError;
import challenge.commons.exception.DomainDuplicatedException;
import challenge.commons.exception.DomainInvalidRequestException;
import challenge.commons.exception.DomainNotFoundException;
import challenge.constants.MensajeHttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

/**
 * Advice para manejar las excepciones genericas de Dominios
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@ControllerAdvice
public class DominioAdvice {

    @ResponseBody
    @ExceptionHandler(DomainDuplicatedException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ApiError domainDuplicatedException(DomainDuplicatedException dominioDuplicadoException){
        return new ApiError(HttpStatus.CONFLICT, MensajeHttpStatus.CONFLICT,
                Collections.singletonList(new ApiFieldError(null, dominioDuplicadoException.getMessage())));
    }

    @ResponseBody
    @ExceptionHandler(DomainNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError domainNotFoundException(DomainNotFoundException dominioNoEncontradoException){
        return new ApiError(HttpStatus.NOT_FOUND, MensajeHttpStatus.NO_ENCONTRADO,
                Collections.singletonList(new ApiFieldError(null, dominioNoEncontradoException.getMessage())));
    }

    @ResponseBody
    @ExceptionHandler(DomainInvalidRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError domainInvalidRequestException(DomainInvalidRequestException dominioInvalidoException){
        return new ApiError(HttpStatus.BAD_REQUEST, MensajeHttpStatus.REQUEST_INCORRECTO,
                Collections.singletonList(new ApiFieldError(null, dominioInvalidoException.getMessage())));
    }
}

