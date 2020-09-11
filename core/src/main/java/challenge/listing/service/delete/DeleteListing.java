package challenge.listing.service.delete;

import challenge.commons.annotation.Service;
import challenge.commons.exception.DomainNotFoundException;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.repository.ListingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Servidor de dominio que contempla el caso de eliminar un listado
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Service
public class DeleteListing {

    private static Logger logger = LoggerFactory.getLogger(DeleteListing.class);

    private ListingRepository listingRepository;

    public DeleteListing(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    /**
     * Verifica que el listado a eliminar, primero exista. Si no existe devuelve un 404
     * @param listingId el identificador de Listing
     * @return el id del objeto eliminado
     */
    public String deleteListingById(ListingId listingId) {
        Listing listing = listingRepository.findById(listingId);
        if (Objects.isNull(listing)) {
            logger.warn("No existe un listado con id {}", listingId.getId());
            throw new DomainNotFoundException(String.format("No existe un listado con id %s ", listingId.getId()));
        }
        listingRepository.deleteById(listingId);
        return listingId.getId();
    }


}
