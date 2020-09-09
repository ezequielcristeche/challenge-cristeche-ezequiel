package challenge.specialprice.repository;

import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;

/**
 * Contiene los métodos a ser implementados por la capa Infra
 *
 * @author Ezequiel Cristeche
 * @since 7/9/2020
 */
public interface SpecialPriceRepository {

    /**
     *  busca un registro en {@link SpecialPrice}
     * @param specialPriceId el identificador de la tabla
     * @return el objeto encontrado
     */
    SpecialPrice findById(SpecialPriceId specialPriceId);

    /**
     * busca un registro en {@link SpecialPrice}
     * @param listingId el identificador de {@link Listing}
     * @return el objeto encontrado
     */
    SpecialPrice findByListingId(ListingId listingId);

    /**
     * guarda un registro en {@link SpecialPrice}
     * @param specialPrice contiene la información necesaria a persistir
     * @return el objeto guardado
     */
    SpecialPrice save(SpecialPrice specialPrice);

    /**
     * elimina un registro de {@link SpecialPrice}
     * @param specialPriceId el identificador de la tabla
     */
    void deleteById(SpecialPriceId specialPriceId);

}
