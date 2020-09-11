package challenge.adapter;

import challenge.commons.annotation.Service;
import challenge.entity.SpecialPriceEntity;
import challenge.listing.domain.ListingId;
import challenge.mapper.SpecialPriceMapper;
import challenge.repository.SpecialPriceJPARepository;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import challenge.specialprice.repository.SpecialPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementa los métodos de la capa core, del domain {@link SpecialPrice}
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Service
public class SpecialPriceImpl implements SpecialPriceRepository {

    @Autowired
    private SpecialPriceJPARepository specialPriceJPARepository;

    @Autowired
    private SpecialPriceMapper specialPriceMapper;


    @Override
    public SpecialPrice findById(SpecialPriceId specialPriceId) {
        SpecialPrice specialPrice = null;
        SpecialPriceEntity specialPriceEntity = specialPriceJPARepository.findById(
                UUID.fromString(specialPriceId.getId())).orElse(null);
        if (Objects.nonNull(specialPriceEntity)) {
            specialPrice = specialPriceMapper.mapToDomain(specialPriceEntity);
        }
        return specialPrice;
    }

    @Override
    public SpecialPrice findByListingId(ListingId listingId) {
        return null;
    }

    @Override
    public SpecialPrice save(SpecialPrice specialPrice) {
        SpecialPriceEntity specialPriceEntity = specialPriceJPARepository.save(
                Objects.requireNonNull(specialPriceMapper.mapToEntity(specialPrice)));
        return specialPriceMapper.mapToDomain(specialPriceEntity);
    }

    @Override
    public void deleteById(SpecialPriceId specialPriceId) {
        specialPriceJPARepository.deleteById(UUID.fromString(specialPriceId.getId()));
    }
}
