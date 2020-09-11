package challenge.dto;

import challenge.listing.domain.Listing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**Clase encargada de mapear la reservada calculada de un {@link Listing}
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateReservationDTO {

    private LocalDate checkin;

    private LocalDate checkout;

}
