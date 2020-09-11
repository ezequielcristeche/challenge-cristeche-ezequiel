package challenge.advice.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.*;

/**
 * Clase que solo informa los errores devueltos en un endpoint
 *
 * @author Ezequiel Cristeche
 * @since 27/5/2020
 */

@Data
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ApiFieldError {

    private String field;
    private String message;

    public ApiFieldError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
