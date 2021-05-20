package org.polo.service.mapper;

import org.mapstruct.*;
import org.polo.domain.*;
import org.polo.service.dto.AuthorDTO;

/**
 * Mapper for the entity {@link Author} and its DTO {@link AuthorDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {}
