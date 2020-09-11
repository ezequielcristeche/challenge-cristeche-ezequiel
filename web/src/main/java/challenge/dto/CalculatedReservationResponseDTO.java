package challenge.dto;

import challenge.listing.domain.Listing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * CLase encargada de mapear la respuesta de una reserva calculada de un {@link Listing}
 *
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedReservationResponseDTO {

    Long nightsCount;

    BigDecimal nightCost;

    BigDecimal discount;

    BigDecimal cleaningFee;

    BigDecimal total;


}
