package challenge.dto;

import challenge.specialprice.domain.SpecialPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**Clase encargada de mapear los datos de {@link SpecialPrice}
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialPriceDTO {

    private LocalDate date;

    private BigDecimal price;
}
