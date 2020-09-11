package challenge.specialprice.service.delete;

import challenge.commons.annotation.Service;
import challenge.listing.domain.ListingId;
import challenge.listing.service.get.GetListing;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import challenge.specialprice.repository.SpecialPriceRepository;
import challenge.specialprice.service.get.GetSpecialPrice;

/**
 * Servidor de dominio que contempla el caso de uso de eliminar un precio especial de un listado
 *
 * @author Ezequiel Cristeche
 * @since 8/9/2020
 */
@Service
public class DeleteSpecialPrice {

    private SpecialPriceRepository specialPriceRepository;

    private GetListing getListing;

    private GetSpecialPrice getSpecialPrice;


    public DeleteSpecialPrice(SpecialPriceRepository specialPriceRepository, GetListing getListing,
                              GetSpecialPrice getSpecialPrice) {
        this.specialPriceRepository = specialPriceRepository;
        this.getListing = getListing;
        this.getSpecialPrice = getSpecialPrice;
    }


    public String deleteSpecialPriceById(ListingId listingId, SpecialPriceId specialPriceId){
        getListing.getListing(listingId);
        SpecialPrice specialPrice = getSpecialPrice.getSpecialPriceById(specialPriceId);
        specialPriceRepository.deleteById(specialPriceId);
        return specialPriceId.getId();
    }
}
