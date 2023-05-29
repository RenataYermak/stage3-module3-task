package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.Author;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T11:21:57+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.5 (JetBrains s.r.o.)"
)
@Component
public class AuthorMapperImpl extends AuthorMapper {

    @Override
    public Author mapAuthorRequestDtoToAuthor(AuthorRequestDto authorDtoRequest) {
        if ( authorDtoRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDtoRequest.id() );
        author.setName( authorDtoRequest.name() );

        return author;
    }

    @Override
    public AuthorResponseDto mapAuthorToAuthorResponseDto(Author authorModel) {
        if ( authorModel == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;

        id = authorModel.getId();
        name = authorModel.getName();
        createDate = authorModel.getCreateDate();
        lastUpdateDate = authorModel.getLastUpdateDate();

        AuthorResponseDto authorResponseDto = new AuthorResponseDto( id, name, createDate, lastUpdateDate );

        return authorResponseDto;
    }

    @Override
    public List<AuthorResponseDto> listAuthorsToAuthorResponseDto(List<Author> authorModelList) {
        if ( authorModelList == null ) {
            return null;
        }

        List<AuthorResponseDto> list = new ArrayList<AuthorResponseDto>( authorModelList.size() );
        for ( Author author : authorModelList ) {
            list.add( mapAuthorToAuthorResponseDto( author ) );
        }

        return list;
    }
}
