package challenge.user.service.consultar;

import challenge.commons.annotation.Service;
import challenge.commons.exception.DomainNotFoundException;
import challenge.user.domain.User;
import challenge.user.domain.UserId;
import challenge.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Servidor de dominio que contempla el caso de uso que consulta un user
 * @author Ezequiel Cristeche
 * @since 7/9/2020
 */
@Service
public class GetUser {

    private static Logger logger = LoggerFactory.getLogger(GetUser.class);
    private UserRepository userRepository;


    public GetUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserById(UserId userId){
        User user = userRepository.findById(userId);
        if(Objects.isNull(user)){
            logger.warn("getUserById --- No existe el usuario con id {}", userId.getId());
            throw new DomainNotFoundException(String.format("No existe el usuario con id %s", userId.getId()));
        }
        return user;
    }
}
