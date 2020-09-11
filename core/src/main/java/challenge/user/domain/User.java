package challenge.user.domain;

import challenge.commons.util.ValidatorUtils;
import lombok.Getter;

/**
 * Domain que representa la tabla users
 *
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Getter
public class User {

    private UserId userId;

    private String name;

    private String email;

    private String password;

    public User(UserId userId, String name, String email, String password) {
        this.userId = userId;
        ValidatorUtils.validateAttribute(name, "el nombre no puede estar vacio",
                60, "el nombre supera el maximo permitido (60)");
        this.name = name;
        ValidatorUtils.validateAttribute(email,"el email no puede estar vacio",
                "^(.+)@(.+)$", "email no válido");
        this.email = email;
        ValidatorUtils.validateAttribute(password,"el password no puede estar vacio", 60,
                "el password supera el maximo permitido (60)");
        this.password = password;
    }
}
