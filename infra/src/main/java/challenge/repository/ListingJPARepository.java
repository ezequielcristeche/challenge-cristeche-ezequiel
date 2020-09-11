package challenge.repository;

import challenge.entity.ListingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**Interface de {@link ListingEntity}
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Repository
public interface ListingJPARepository extends JpaRepository<ListingEntity, UUID> {
}
