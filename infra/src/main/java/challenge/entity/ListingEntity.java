package challenge.entity;

import challenge.specialprice.domain.SpecialPrice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**Entidad de la tabla listings
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listings")
public class ListingEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String slug;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String description;

    @Column(nullable = false, columnDefinition = "INT(11)")
    private Integer adults;

    @Column(nullable = false, columnDefinition = "INT(11)")
    private Integer childrens;

    @Column(name = "is_pets_allowed", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean isPetsAllowed;

    @Column(name = "base_price", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private BigDecimal basePrice;

    @Column(name = "cleaning_fee", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private BigDecimal cleaningFee;

    @Column(name = "image_url", nullable = false, columnDefinition = "VARCHAR(256)")
    private String imageUrl;

    @Column(name = "weekly_discount", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private BigDecimal weeklyDiscount;

    @Column(name = "monthly_discount", nullable = false, columnDefinition = "DECIMAL(10,4)")
    private BigDecimal monthlyDiscount;

    @OneToMany(targetEntity = SpecialPriceEntity.class, fetch = FetchType.LAZY)
    private List<SpecialPriceEntity> specialPriceEntityList;


    public ListingEntity(UUID uuid){
        this.id = uuid;
    }



}
