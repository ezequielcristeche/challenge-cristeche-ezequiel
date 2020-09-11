package challenge.mapper;

import challenge.entity.UserEntity;
import challenge.user.domain.User;
import challenge.user.domain.UserId;
import org.springframework.stereotype.Component;

import java.util.UUID;

/** se encarga de mapear los objetos de Entity a Domain y viceversa
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Component
public class UserMapper implements AbstractMapper<UserEntity, User> {


    @Override
    public User mapToDomain(UserEntity entity) {
        return new User(new UserId(entity.getId().toString()), entity.getName(),
                entity.getEmail(), entity.getPassword());
    }

    @Override
    public UserEntity mapToEntity(User domain) {
        return new UserEntity(UUID.fromString(domain.getUserId().getId()), domain.getName(),
                domain.getEmail(), domain.getPassword());
    }
}
