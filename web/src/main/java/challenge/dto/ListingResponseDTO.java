package challenge.dto;

import challenge.listing.domain.Listing;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**Clase encargada de mapear la respuesta de {@link Listing}
 * @author Ezequiel Cristeche
 * @since 9/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ListingResponseDTO {

    private String id;

    private String ownerId;

    private String name;

    private String slug;

    private String description;

    private Integer adults;

    private Integer children;

    private Boolean itPetsAllowed;

    private BigDecimal basePrice;

    private BigDecimal cleaningFee;

    private String imageUrl;

    private BigDecimal weeklyDiscount;

    private BigDecimal monthlyDiscount;

    @JsonProperty("special_prices")
    private List<SpecialPriceResponseDTO> specialPriceResponseDTOList;

}
