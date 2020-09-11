package challenge.mapper;

import challenge.entity.ListingEntity;
import challenge.entity.SpecialPriceEntity;
import challenge.entity.UserEntity;
import challenge.listing.domain.Listing;
import challenge.listing.domain.ListingId;
import challenge.specialprice.domain.SpecialPrice;
import challenge.specialprice.domain.SpecialPriceId;
import challenge.user.domain.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Se encarga de mapear los objetos de Entity a Domain y viceversa
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Component
public class ListingMapper implements AbstractMapper<ListingEntity, Listing> {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SpecialPriceMapper specialPriceMapper;

    @Override
    public Listing mapToDomain(ListingEntity entity) {

        if (Objects.nonNull(entity.getSpecialPriceEntityList())) {
            return new Listing(new ListingId(entity.getId().toString()), new UserId(entity.getUserEntity().getId().toString()),
                    entity.getName(), entity.getSlug(), entity.getDescription(), entity.getAdults(), entity.getChildrens(),
                    entity.getIsPetsAllowed(), entity.getBasePrice(), entity.getCleaningFee(),
                    entity.getImageUrl(), entity.getWeeklyDiscount(), entity.getWeeklyDiscount(),
                    entity.getSpecialPriceEntityList().stream().map(specialPriceEntity ->
                            new SpecialPrice(new SpecialPriceId(specialPriceEntity.getId().toString()),
                                    new ListingId(specialPriceEntity.getListingEntity().getId().toString()),
                                    specialPriceEntity.getDate(), specialPriceEntity.getPrice())).collect(Collectors.toList()));
        } else {
            return new Listing(new ListingId(entity.getId().toString()), new UserId(entity.getUserEntity().getId().toString()),
                    entity.getName(), entity.getSlug(), entity.getDescription(), entity.getAdults(), entity.getChildrens(),
                    entity.getIsPetsAllowed(), entity.getBasePrice(), entity.getCleaningFee(),
                    entity.getImageUrl(), entity.getWeeklyDiscount(), entity.getWeeklyDiscount(),
                    null);
        }
    }

    @Override
    public ListingEntity mapToEntity(Listing domain) {

        if (Objects.nonNull(domain.getSpecialPriceList())) {
            return new ListingEntity(UUID.randomUUID(), new UserEntity(UUID.fromString(domain.getOwnerId().getId())), domain.getName(), domain.getSlug(),
                    domain.getDescription(), domain.getAdults(), domain.getChildren(), domain.getIsPetsAllowed(),
                    domain.getBasePrice(), domain.getCleaningFee(), domain.getImageUrl(), domain.getWeeklyDiscount(),
                    domain.getMonthlyDiscount(), domain.getSpecialPriceList().stream().map(specialPrice ->
                    new SpecialPriceEntity(UUID.fromString(specialPrice.getListingId().getId()), null, specialPrice.getDate(),
                            specialPrice.getPrice())).collect(Collectors.toList()));
        } else {
            return new ListingEntity(UUID.randomUUID(), new UserEntity(UUID.fromString(domain.getOwnerId().getId())), domain.getName(), domain.getSlug(),
                    domain.getDescription(), domain.getAdults(), domain.getChildren(), domain.getIsPetsAllowed(),
                    domain.getBasePrice(), domain.getCleaningFee(), domain.getImageUrl(), domain.getWeeklyDiscount(),
                    domain.getMonthlyDiscount(), null);
        }
    }
}
