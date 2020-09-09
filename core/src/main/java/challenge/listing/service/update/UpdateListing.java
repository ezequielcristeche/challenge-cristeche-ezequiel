package challenge.listing.service.update;

import challenge.commons.annotation.Service;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.repository.ListingRepository;
import challenge.listing.service.get.GetListing;

import java.math.BigDecimal;

/**
 * Servidor de dominio que contempla el caso de actualizar un listado
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Service
public class UpdateListing {

    private ListingRepository listingRepository;

    private GetListing getListing;


    public UpdateListing(ListingRepository listingRepository, GetListing getListing) {
        this.listingRepository = listingRepository;
        this.getListing = getListing;
    }

    /**
     * se encarga de validar si el listado existe para ser actualizado
     *
     * @param listingId para buscar el listado a actualizar
     * @param name del listado
     * @param description del listado
     * @param adults del listado
     * @param children del listado
     * @param isPetsAllowed del listado
     * @param basePrice del listado
     * @param cleaningFee del listado
     * @param imageUrl del listado
     * @param weeklyDiscount del listado
     * @param monthlyDiscount del listado
     * @return el listado actualizado
     */
    public Listing updateListing(ListingId listingId, String name, String description,
                                 Integer adults, Integer children, Boolean isPetsAllowed, BigDecimal basePrice,
                                 BigDecimal cleaningFee, String imageUrl, BigDecimal weeklyDiscount,
                                 BigDecimal monthlyDiscount) {
        Listing listing = getListing.getListing(listingId);
        return listingRepository.update(Listing.actualizar(listingId, listing.getOwnerId(), name,
                listing.getSlug(), description, adults, children, isPetsAllowed, basePrice, cleaningFee, imageUrl,
                weeklyDiscount, monthlyDiscount));
    }

}
