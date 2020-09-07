package challenge.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Utilitario para dar formato a excepciones.
 *
 * @author Ezequiel Cristeche
 * @version 1.0.0
 * @since 06/09/2020
 */
public class DataBaseErrorBuilder {

    private static final String CONSTRAINT_ERROR_PREV = "El campo: ";
    private static final String CONSTRAINT_ERROR_COMPLETE= " no coincide con ningun campo cargado.";

    /**
     * Arma un String para la excepcion de las FK.
     *
     * @param exceptionMessage el mensaje de la excepcion. El Error Code debe ser 1452 para su correcto funcionamiento.
     * @return String para devolver en el message de la excepcion
     */
    public static String buildConstraintException (String exceptionMessage){
        String fieldName = StringUtils.substringBetween(exceptionMessage, "FOREIGN KEY (`", "`) REFERENCES `");
        return CONSTRAINT_ERROR_PREV + fieldName + CONSTRAINT_ERROR_COMPLETE;
    }


}
