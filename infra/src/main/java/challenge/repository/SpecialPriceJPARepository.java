package challenge.repository;

import challenge.entity.SpecialPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**Interface de {@link SpecialPriceEntity}
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Repository
public interface SpecialPriceJPARepository extends JpaRepository<SpecialPriceEntity, UUID> {
}
