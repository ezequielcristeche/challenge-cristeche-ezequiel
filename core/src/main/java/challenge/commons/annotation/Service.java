package challenge.commons.annotation;

import java.lang.annotation.*;

/**Annotation personalizada para implementar en los casos de uso
 * @author Ezequiel Cristeche
 * @since 6/9/2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface Service {
}


