package challenge.advice;

import java.util.Collections;

import challenge.advice.error.ApiError;
import challenge.advice.error.ApiFieldError;
import challenge.constants.MensajeHttpStatus;
import com.ma.grossingup.exception.DataBaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Manejador de exceptions de la base de datos
 *
 * @author Ezequiel Cristeche
 * @version 1.0.0
 * @since 6/09/2020
 */
@ControllerAdvice
public class BaseDeDatosAdvice {

    /**
     * Manejador de {@link DataBaseException}
     *
     * @param ex {@link DataBaseException}
     * @return los errores correspondientes a base de datos
     */
    @ResponseBody
    @ExceptionHandler(DataBaseException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError ExceptionHandlerDataBase(DataBaseException ex) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, MensajeHttpStatus.ERROR_INTERNO,
                Collections.singletonList(new ApiFieldError(null, ex.getMessage())));
    }

}
