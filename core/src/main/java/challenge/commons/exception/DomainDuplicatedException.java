package challenge.commons.exception;


/**
 * Exception que se dispara cuando el dominio ya se encuentra insertado
 *
 * @author Ezequiel Cristeche
 * @since 27/5/2020
 */

public class DomainDuplicatedException extends RuntimeException{


	private static final long serialVersionUID = 3677193632656200774L;


	public DomainDuplicatedException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }


    public DomainDuplicatedException(String mensaje) {
        super(mensaje);
    }
}
