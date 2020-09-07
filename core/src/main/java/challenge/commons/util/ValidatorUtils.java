package challenge.commons.util;

import challenge.commons.exception.DomainInvalidRequestException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Utilities para validar los dominios
 *
 * @author Ezequiel Cristeche
 * @version 1.0.0
 * @since 6/09/2020
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidatorUtils {


    /**
     * Valida que un objeto no pueda ser nulo
     *
     * @param object para validar
     * @param errorMessage de error
     */
    public static void validateNull(Object object, String errorMessage) {
        if (Objects.isNull(object)) {
            throw new DomainInvalidRequestException(errorMessage);
        }
    }

    /**
     * Valida que un atributo del dominio no sea nulo,
	 * y que respete la longitud indicada en la base de datos
     * @param attribute para validar
     * @param messageInvalidAttribute error atributo inválido
     * @param length para validar
     * @param messageInvalidLength supera el maximo permitido por la BD
     */
    public static void validateAttribute(String attribute, String messageInvalidAttribute, int length,
                                         String messageInvalidLength) {
        if (StringUtils.isBlank(attribute)) {
            throw new DomainInvalidRequestException(messageInvalidAttribute);
        }
        if (attribute.length() > length) {
            throw new DomainInvalidRequestException(messageInvalidLength);
        }
    }

    /**
     * Validar un atributo con una expresión regular.
     *
     * @param attribute
     * @param messageInvalidAttribute mensaje cuando el dato esta vacío
     * @param regExp expresión regular
     * @param messageInvalidExpression mensaje cuando el dato no cumple la expresión regular
     */
    public static void validateAttribute(String attribute, String messageInvalidAttribute, String regExp,
                                       String messageInvalidExpression) {
        if (StringUtils.isBlank(attribute)) {
            throw new DomainInvalidRequestException(messageInvalidAttribute);
        }
        if (!(Pattern.compile(regExp).matcher(attribute).find())) {
            throw new DomainInvalidRequestException(messageInvalidExpression);
        }
    }

}