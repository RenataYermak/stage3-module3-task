package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
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
public class NewsMapperImpl extends NewsMapper {

    @Override
    public News mapNewsRequestDtoToNews(NewsRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        News news = new News();

        news.setAuthor( newsRequestDtoToAuthor( dto ) );
        news.setId( dto.id() );
        news.setTitle( dto.title() );
        news.setContent( dto.content() );

        return news;
    }

    @Override
    public NewsResponseDto mapNewsToNewsResponseDto(News news) {
        if ( news == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String content = null;
        LocalDateTime createDate = null;
        LocalDateTime lastUpdateDate = null;

        id = news.getId();
        title = news.getTitle();
        content = news.getContent();
        createDate = news.getCreateDate();
        lastUpdateDate = news.getLastUpdateDate();

        Long tagId = null;
        AuthorResponseDto authorDto = news.getAuthor().getId() != null ? authorService.readById(news.getAuthor().getId()) : null;

        NewsResponseDto newsResponseDto = new NewsResponseDto( id, title, content, createDate, lastUpdateDate, authorDto, tagId );

        return newsResponseDto;
    }

    @Override
    public List<NewsResponseDto> mapNewsToNewsResponseDtoList(List<News> newsCollection) {
        if ( newsCollection == null ) {
            return null;
        }

        List<NewsResponseDto> list = new ArrayList<NewsResponseDto>( newsCollection.size() );
        for ( News news : newsCollection ) {
            list.add( mapNewsToNewsResponseDto( news ) );
        }

        return list;
    }

    protected Author newsRequestDtoToAuthor(NewsRequestDto newsRequestDto) {
        if ( newsRequestDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( newsRequestDto.authorId() );

        return author;
    }
}
