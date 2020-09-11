package challenge.repository;

import challenge.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** Interface de {@link UserEntity}
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, UUID> {
}
