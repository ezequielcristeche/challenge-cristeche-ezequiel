package challenge.listing.repository;

import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;

import java.util.List;

/** Contiene los métodos a ser implementados por la capa Infra
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
public interface ListingRepository {

    /**
     * guarda un registro en {@link Listing}
     * @param listing contiene la información que va a persistirse
     * @return el objeto guardado
     */
    Listing save(Listing listing);

    /**
     * actualiza un registro de {@link Listing}
     * @param listing contiene la informacion para ser actualizada
     * @return el objeto actualizado
     */
    Listing update(Listing listing);

    /**
     * Busca un registro de {@link Listing}
     * @param listingId el identificador de la tabla
     * @return el objeto encontrado
     */
    Listing findById(ListingId listingId);

    /**
     * Trae todos los registros de {@link Listing}
     * @return
     */
    List<Listing> findAll();

    /**
     * borra un registro de {@link Listing}
     * @param listingId el identificador de la tabla
     */
    void deleteById(ListingId listingId);





}
