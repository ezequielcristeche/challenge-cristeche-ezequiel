package challenge.mapper;

import org.springframework.lang.Nullable;

/**
 * Interface para mapear las entidades
 *
 * @author Ezequiel Cristeche
 * @since 06/09/2020
 */
public interface AbstractMapper<S, T> {

    /**
     * mapea un Entity a Domain
     * @param entity el objeto a mapear
     * @return el domain mapeado
     */
    @Nullable
    T mapToDomain(S entity);

    /**
     * mapea un Domain a Entity
     * @param domain el objeto a mapear
     * @return el entity mapeado
     */
    @Nullable
    S mapToEntity(T domain);
}
