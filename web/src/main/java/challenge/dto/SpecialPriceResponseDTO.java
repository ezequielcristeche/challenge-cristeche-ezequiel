package challenge.dto;

import challenge.specialprice.domain.SpecialPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/** Clase encargada de mapear la respuesta de un {@link SpecialPrice}
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecialPriceResponseDTO {

    private String id;

    private LocalDate date;

    private BigDecimal price;
}
