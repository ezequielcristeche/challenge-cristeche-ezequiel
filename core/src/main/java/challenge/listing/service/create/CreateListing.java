package challenge.listing.service.create;

import challenge.commons.annotation.Service;
import challenge.listing.domain.Listing;
import challenge.listing.repository.ListingRepository;
import challenge.user.domain.User;
import challenge.user.domain.UserId;
import challenge.user.service.consultar.GetUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.math.BigDecimal;

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
    public Listing createListing(UserId ownerId, String name, String slug, String description,
                                 Integer adults, Integer children, Boolean isPetsAllowed, BigDecimal basePrice,
                                 BigDecimal cleaningFee, String imageUrl, BigDecimal weeklyDiscount,
                                 BigDecimal monthlyDiscount) {
        logger.info("Creating a listing with id");
        User user = getUser.getUserById(ownerId);
        return listingRepository.save(Listing.crear(user.getUserId(), name, slug, description,
                adults, children, isPetsAllowed, basePrice, cleaningFee, imageUrl, weeklyDiscount, monthlyDiscount));
    }

}
