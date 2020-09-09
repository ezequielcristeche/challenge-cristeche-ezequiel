package challenge.listing.service.create;

import challenge.commons.annotation.Service;
import challenge.commons.exception.DomainDuplicatedException;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.repository.ListingRepository;
import challenge.user.domain.User;
import challenge.user.domain.UserId;
import challenge.user.service.consultar.GetUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Servidor de dominio que contempla el caso de crear un listado
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Service
public class CreateListing {

    private static Logger logger = LoggerFactory.getLogger(CreateListing.class);

    private GetUser getUser;

    private ListingRepository listingRepository;

    public CreateListing(GetUser consultarUser, ListingRepository listingRepository) {
        this.getUser = consultarUser;
        this.listingRepository = listingRepository;
    }


    @Transactional
    public Listing createListing(ListingId listingId, UserId ownerId, String name, String slug, String description,
                                 Integer adults, Integer children, Boolean isPetsAllowed, BigDecimal basePrice,
                                 BigDecimal cleaningFee, String imageUrl, BigDecimal weeklyDiscount,
                                 BigDecimal monthlyDiscount) {
        logger.info("Creating a listing with id {}", listingId.getId());
        User user = getUser.getUserById(ownerId);
        verifyListingDuplicated(listingId);
        return listingRepository.save(Listing.crear(listingId, user.getUserId(), name, slug, description,
                adults, children, isPetsAllowed, basePrice, cleaningFee, imageUrl, weeklyDiscount, monthlyDiscount));
    }

    /**
     * Verifica que antes de crear un listado, no exista el mismo
     *
     * @param listingId el identificador para realizar la busqueda
     */
    private void verifyListingDuplicated(ListingId listingId) {
        Listing listing = listingRepository.findById(listingId);
        if (Objects.nonNull(listing)) {
            logger.warn("verifyListingDuplicated --- Ya existe un listado con id {}", listingId.getId());
            throw new DomainDuplicatedException(String.format("Ya existe un listado con id: %s ", listingId.getId()));
        }
    }
}
