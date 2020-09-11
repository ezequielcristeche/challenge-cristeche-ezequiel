package challenge.commons.util;

import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utilities para validar los identificadores de los dominios
 * 
 * @author Ezequiel Cristeche
 * @version 1.0.0
 * @since 06/09/2020
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdentifierUtils {


	/**
	 * Validación para un identificador de tipo {@link String}
	 *
	 * @param id identificador del dominio
	 * @return si cumple con
	 */
	public static boolean isValidUUID(String id) {
		return Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}").matcher(id).find();
	}
}