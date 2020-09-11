package challenge.commons.exception;


/**
 * Exception generico para los datos no validos enviados en los servicios
 *
 * @author Ezequiel Cristeche
 * @since 27/5/2020
 */

public class DomainInvalidRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6417559778965033514L;

	public DomainInvalidRequestException(String mensaje) {
        super(mensaje);
    }
}
