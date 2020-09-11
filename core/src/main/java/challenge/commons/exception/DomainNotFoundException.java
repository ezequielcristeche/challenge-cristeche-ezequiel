package challenge.commons.exception;

/**
 * Excepcion que se dispara cuando no se encuentra el dominio
 *
 * @author Ezequiel Cristeche
 * @since 27/5/2020
 */

public class DomainNotFoundException extends RuntimeException {

 
	private static final long serialVersionUID = -2176780934196844927L;

	public DomainNotFoundException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public DomainNotFoundException(String mensaje) {
        super(mensaje);
    }
}
