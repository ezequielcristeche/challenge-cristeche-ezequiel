package challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Entidad de la tabla users
 *
 * @author Ezequiel Cristeche
 * @since 10/9/2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(nullable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(256)")
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(60)")
    private String password;

    public UserEntity(UUID uuid){
        this.id = uuid;
    }


}
