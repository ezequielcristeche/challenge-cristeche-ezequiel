package challenge.specialprice.domain;

import challenge.commons.util.ValidatorUtils;
import challenge.listing.domain.ListingId;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

/**Domain representativo de la tabla special_prices
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Getter
public class SpecialPrice {

    private SpecialPriceId specialPriceId;

    private ListingId listingId;

    private LocalDate date;

    private BigDecimal price;

    public SpecialPrice(SpecialPriceId specialPriceId, ListingId listingId, LocalDate date, BigDecimal price) {
        this.specialPriceId = specialPriceId;
        this.listingId = listingId;
        ValidatorUtils.validateNull(date,"La fecha no puede ser nula");
        this.date = date;
        ValidatorUtils.validateNull(price,"el precio no puede ser nulo");
        this.price = price;
    }

    public SpecialPrice(ListingId listingId, LocalDate date, BigDecimal price) {
        this.specialPriceId = specialPriceId;
        this.listingId = listingId;
        ValidatorUtils.validateNull(date,"La fecha no puede ser nula");
        this.date = date;
        ValidatorUtils.validateNull(price,"el precio no puede ser nulo");
        this.price = price;
    }


    public static SpecialPrice create(ListingId listingId,
                                      LocalDate date, BigDecimal price){
        return new SpecialPrice(listingId, date, price);
    }

}
