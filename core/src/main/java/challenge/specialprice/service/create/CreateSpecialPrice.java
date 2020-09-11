package challenge.specialprice.service.create;

import challenge.commons.annotation.Service;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.service.get.GetListing;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.repository.SpecialPriceRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Servidor de dominio que contempla el caso de uso de crear un Special Price
 *
 * @author Ezequiel Cristeche
 * @since 7/9/2020
 */
@Service
public class CreateSpecialPrice {

    private SpecialPriceRepository specialPriceRepository;

    private GetListing getListing;

    public CreateSpecialPrice(SpecialPriceRepository specialPriceRepository, GetListing getListing) {
        this.specialPriceRepository = specialPriceRepository;
        this.getListing = getListing;
    }

    /**
     * Le agrega un precio especial a una lista determinada
     * @param listingId el identificador del listado
     * @param date la fecha del precio especial
     * @param price el precio
     * @return el objeto creado
     */
    @Transactional
    public SpecialPrice createSpecialPrice(ListingId listingId, LocalDate date, BigDecimal price) {
        Listing listing = getListing.getListing(listingId);
        return specialPriceRepository.save(SpecialPrice.create(listing.getListingId(), date, price));
    }

}
