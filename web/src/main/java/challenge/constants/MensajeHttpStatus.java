package challenge.constants;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Mensajes gen�ricos para los {@link HttpStatus}
 *
 * @author Silvana Mossi
 * @version 1.0.0
 * @since 12/09/2019
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MensajeHttpStatus {
	
	  /**
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     */
    public static final String ERROR_INTERNO = "Error interno del servidor";

    /**
     * {@link HttpStatus#UNAUTHORIZED}
     */
    public static final String NO_AUTORIZADO = "No autorizado";

    /**
     * {@link HttpStatus#BAD_REQUEST}
     */
    public static final String REQUEST_INCORRECTO = "El request no es correcto";

    /**
     * {@link HttpStatus#CONFLICT}
     */
    public static final String CONFLICT = "Conflicto";

    /**
     * {@link HttpStatus#NOT_FOUND}
     */
    public static final String NO_ENCONTRADO = "No Encontrado";


}
