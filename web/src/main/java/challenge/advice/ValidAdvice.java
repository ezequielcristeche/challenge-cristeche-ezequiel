package challenge.advice;

import challenge.advice.error.ApiError;
import challenge.advice.error.ApiFieldError;
import challenge.constants.MensajeHttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ezequiel Cristeche
 * @since 16/06/2020
 */
@ControllerAdvice
public class ValidAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiError ExceptionHandlerMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        List<ApiFieldError> errors = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            ApiFieldError ret = new ApiFieldError();
            ret.setField(error.getField());
            ret.setMessage(error.getDefaultMessage());
            errors.add(ret);
        }
        return new ApiError(HttpStatus.BAD_REQUEST, MensajeHttpStatus.REQUEST_INCORRECTO,
                errors);
    }
}
