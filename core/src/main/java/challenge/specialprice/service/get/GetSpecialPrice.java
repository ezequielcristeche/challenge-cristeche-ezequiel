package challenge.specialprice.service.get;

import challenge.commons.annotation.Service;
import challenge.commons.exception.DomainNotFoundException;
import challenge.listing.domain.ListingId;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import challenge.specialprice.repository.SpecialPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Servidor de dominio que contempla el caso de uso de obtener un precio especial de un listado
 *
 * @author Ezequiel Cristeche
 * @since 7/9/2020
 */
@Service
public class GetSpecialPrice {

    private static Logger logger = LoggerFactory.getLogger(GetSpecialPrice.class);

    private SpecialPriceRepository specialPriceRepository;

    public GetSpecialPrice(SpecialPriceRepository specialPriceRepository) {
        this.specialPriceRepository = specialPriceRepository;
    }

    public SpecialPrice getSpecialPriceById(SpecialPriceId specialPriceId) {
        SpecialPrice specialPrice = specialPriceRepository.findById(specialPriceId);
        if (Objects.isNull(specialPrice)) {
            logger.warn("getSpecialPriceById --- No existe el precio especial con id {}", specialPriceId.getId());
            throw new DomainNotFoundException(String.format("No existe el precio especial con id %s",
                    specialPriceId.getId()));
        }
        return specialPrice;
    }

    public SpecialPrice getSpecialPriceByListingId(ListingId listingId) {
        SpecialPrice specialPrice = specialPriceRepository.findByListingId(listingId);
        if (Objects.isNull(specialPrice)) {
            logger.warn("getSpecialPriceByListingId --- No hay precios especiales para " +
                    "el listado con id {}", listingId.getId());
            throw new DomainNotFoundException(String.format("No hay precios especiales para " +
                    "el listado con id %s", listingId.getId()));
        }
        return specialPrice;
    }


}
