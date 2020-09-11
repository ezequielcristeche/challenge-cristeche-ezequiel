package challenge.exception;

/**
 * Exception genérica para los errores en base de datos
 *
 * @author Ezequiel Cristeche
 * @version 1.0.0
 * @since 06/09/2020
 */
public class DataBaseException extends RuntimeException {
    private static final long serialVersionUID = -3929378043599939962L;

    /**
     * Constructor
     *
     * @param mensaje mensaje propio de la excepción
     */
    public DataBaseException(String mensaje) {
        super(mensaje);
    }

}
