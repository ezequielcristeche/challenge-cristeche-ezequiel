package challenge.specialprice.domain;

import challenge.commons.exception.DomainInvalidRequestException;
import challenge.commons.util.IdentifierUtils;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

/**Value Object que representa el identificador de {@link SpecialPrice}
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Value
public class SpecialPriceId {

    //no se agrega el modificador de acceso porque el @Value indica que es un objeto inmutable
    String id;

    public SpecialPriceId(String id) {
        if (StringUtils.isBlank(id) || !IdentifierUtils.isValidUUID(id)) {
            throw new DomainInvalidRequestException("El id del user no es válido");
        }
        this.id = id;
    }

}
