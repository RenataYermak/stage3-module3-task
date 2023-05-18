package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Author;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.AuthorMapper;
import com.mjc.school.service.validation.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AuthorService implements BaseService<AuthorRequestDto, AuthorResponseDto, Long> {

    private final BaseRepository<Author, Long> authorRepository;
    private final AuthorMapper mapper;

    @Autowired
    public AuthorService(BaseRepository<Author, Long> repository, AuthorMapper mapper) {
        this.authorRepository = repository;
        this.mapper = mapper;
    }

    @Validate
    @Override
    public List<AuthorResponseDto> readAll() {
        return mapper.listAuthorsToAuthorResponseDto(authorRepository.readAll());
    }

    @Validate(value = "checkAuthorId")
    @Override
    public AuthorResponseDto readById(Long id) {
        if (authorRepository.existById(id)) {
            return mapper.mapAuthorToAuthorResponseDto(authorRepository.readById(id).get());
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", id));
        }
    }

    @Validate(value = "checkAuthor")
    @Override
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        var author = mapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
        var localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        author.setCreateDate(localDateTime);
        author.setLastUpdateDate(localDateTime);
        var createdAuthor = authorRepository.create(author);
        return mapper.mapAuthorToAuthorResponseDto(createdAuthor);
    }

    @Validate(value = "checkAuthor")
    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto) {
        if (authorRepository.existById(authorRequestDto.id())) {
            var author = mapper.mapAuthorRequestDtoToAuthor(authorRequestDto);
            var localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            author.setName(authorRequestDto.name());
            author.setLastUpdateDate(localDateTime);
            return mapper.mapAuthorToAuthorResponseDto(authorRepository.update(author));
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", authorRequestDto.id()));
        }
    }

    @Validate(value = "checkAuthorId")
    @Override
    public boolean deleteById(Long id) {
        if (authorRepository.existById(id)) {
            return authorRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Author with ID %d not found.", id));
        }
    }
}