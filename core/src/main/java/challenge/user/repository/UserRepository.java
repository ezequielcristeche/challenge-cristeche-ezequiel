package challenge.user.repository;

import challenge.user.domain.User;
import challenge.user.domain.UserId;

/** Contiene los métodos a ser implementados por la capa Infra
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
public interface UserRepository {

    /**
     * busca un registro en @{@link User}
     * @param userId el identificador de la tabla
     * @return el objeto encontrado
     */
    User findById(UserId userId);
}
