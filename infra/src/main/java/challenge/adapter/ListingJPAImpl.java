package challenge.adapter;

import challenge.commons.annotation.Service;
import challenge.entity.ListingEntity;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.listing.repository.ListingRepository;
import challenge.mapper.ListingMapper;
import challenge.repository.ListingJPARepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementa los métodos de la capa core, del domain {@link Listing}
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Service
public class ListingJPAImpl implements ListingRepository {

    @Autowired
    private ListingJPARepository listingJPARepository;

    @Autowired
    private ListingMapper listingMapper;

    @Override
    public Listing save(Listing listing) {
        ListingEntity listingEntity = listingJPARepository.save(Objects.requireNonNull(listingMapper.mapToEntity(listing)));
        return listingMapper.mapToDomain(listingEntity);
    }

    @Override
    public Listing update(Listing listing) {
        ListingEntity listingEntity = listingJPARepository.save(Objects.requireNonNull(listingMapper.mapToEntity(listing)));
        return listingMapper.mapToDomain(listingEntity);
    }

    @Override
    public Listing findById(ListingId listingId) {
        Listing listing = null;
        ListingEntity listingEntity = listingJPARepository.findById(UUID.fromString(listingId.getId())).orElse(null);
        if (Objects.nonNull(listingEntity)) {
            listing = listingMapper.mapToDomain(listingEntity);
        }
        return listing;
    }

    @Override
    public List<Listing> findAll() {
        List<ListingEntity> listingEntityList = listingJPARepository.findAll();
        return listingEntityList.stream().map(listingEntity -> listingMapper.mapToDomain(listingEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(ListingId listingId) {
        listingJPARepository.deleteById(UUID.fromString(listingId.getId()));
    }
}
