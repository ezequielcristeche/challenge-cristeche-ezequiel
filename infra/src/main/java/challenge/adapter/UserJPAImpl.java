package challenge.adapter;

import challenge.commons.annotation.Service;
import challenge.entity.UserEntity;
import challenge.mapper.UserMapper;
import challenge.repository.UserJPARepository;
import challenge.user.domain.User;
import challenge.user.domain.UserId;
import challenge.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementa los métodos de la capa core, del domain {@link User}
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Service
public class UserJPAImpl implements UserRepository {

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(UserId userId) {
        User user = null;
        UserEntity userEntity = userJPARepository.findById(UUID.fromString(userId.getId())).orElse(null);
        if (Objects.nonNull(userEntity)) {
            user = userMapper.mapToDomain(userEntity);
        }
        return user;
    }
}
