package challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de la tabla special_prices
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "special_prices")
public class SpecialPriceEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private ListingEntity listingEntity;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate date;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,4)")
    private BigDecimal price;


}
