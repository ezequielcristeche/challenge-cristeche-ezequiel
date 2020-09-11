package challenge.mapper;

import challenge.entity.ListingEntity;
import challenge.entity.SpecialPriceEntity;
import challenge.listing.domain.ListingId;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Se encarga de mapear los objetos de Entity a Domain y viceversa
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Component
public class SpecialPriceMapper implements AbstractMapper<SpecialPriceEntity, SpecialPrice> {


    @Override
    public SpecialPrice mapToDomain(SpecialPriceEntity entity) {
        return new SpecialPrice(new SpecialPriceId(entity.getId().toString()),
                new ListingId(entity.getListingEntity().getId().toString()), entity.getSpecialPriceDate(), entity.getPrice());
    }

    @Override
    public SpecialPriceEntity mapToEntity(SpecialPrice domain) {
        return new SpecialPriceEntity(UUID.randomUUID(),
                new ListingEntity(UUID.fromString(domain.getListingId().getId())), domain.getDate(), domain.getPrice());
    }
}
