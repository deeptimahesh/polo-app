package org.polo.service.impl;

import java.util.Optional;
import org.polo.domain.Author;
import org.polo.repository.AuthorRepository;
import org.polo.service.AuthorService;
import org.polo.service.dto.AuthorDTO;
import org.polo.service.mapper.AuthorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing {@link Author}.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO) {
        log.debug("Request to save Author : {}", authorDTO);
        Author author = authorMapper.toEntity(authorDTO);
        author = authorRepository.save(author);
        return authorMapper.toDto(author);
    }

    @Override
    public Optional<AuthorDTO> partialUpdate(AuthorDTO authorDTO) {
        log.debug("Request to partially update Author : {}", authorDTO);

        return authorRepository
            .findById(authorDTO.getId())
            .map(
                existingAuthor -> {
                    authorMapper.partialUpdate(existingAuthor, authorDTO);
                    return existingAuthor;
                }
            )
            .map(authorRepository::save)
            .map(authorMapper::toDto);
    }

    @Override
    public Page<AuthorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Authors");
        return authorRepository.findAll(pageable).map(authorMapper::toDto);
    }

    @Override
    public Optional<AuthorDTO> findOne(String id) {
        log.debug("Request to get Author : {}", id);
        return authorRepository.findById(id).map(authorMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Author : {}", id);
        authorRepository.deleteById(id);
    }
}
