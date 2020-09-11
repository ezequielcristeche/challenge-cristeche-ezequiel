package challenge.dto;

import challenge.listing.domain.Listing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**Clase encargada de mapear los datos de {@link Listing}
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingDTO {

    private String ownerId;

    private String name;

    private String description;

    private Integer adults;

    private Integer children;

    private Boolean isPetsAllowed;

    private BigDecimal basePrice;

    private BigDecimal cleaningFee;

    private String imageUrl;

    private BigDecimal weeklyDiscount;

    private BigDecimal monthlyDiscount;


}
