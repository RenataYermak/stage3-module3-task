package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validation.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NewsService implements BaseService<NewsRequestDto, NewsResponseDto, Long> {

    private final BaseRepository<Author, Long> authorRepository;
    private final BaseRepository<News, Long> newsRepository;
    private final NewsMapper mapper;

    @Autowired
    public NewsService(BaseRepository<Author, Long> authorRepository, BaseRepository<News, Long> newsRepository, NewsMapper mapper) {
        this.authorRepository = authorRepository;
        this.newsRepository = newsRepository;
        this.mapper = mapper;
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return mapper.mapNewsToNewsResponseDtoList(newsRepository.readAll());
    }

    @Validate(value = "checkNewsId")
    @Override
    public NewsResponseDto readById(Long id) {
        if (newsRepository.existById(id)) {
            var optionalNews = newsRepository.readById(id);
            return mapper.mapNewsToNewsResponseDto(optionalNews.get());
        } else {
            throw new NotFoundException(String.format("News with ID %d not found.", id));
        }
    }

    @Validate(value = "checkNews")
    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        if (authorRepository.existById(newsRequestDto.authorId())) {
            var news = mapper.mapNewsRequestDtoToNews(newsRequestDto);
            var localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            news.setCreateDate(localDateTime);
            news.setLastUpdateDate(localDateTime);
            var savedNews = newsRepository.create(news);
            return mapper.mapNewsToNewsResponseDto(savedNews);
        } else {
            throw new NotFoundException(
                    String.format("Author with ID %d not found.", newsRequestDto.authorId()));
        }
    }

    @Validate(value = "checkNews")
    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        if (authorRepository.existById(newsRequestDto.authorId())) {
            if (newsRepository.existById(newsRequestDto.id())) {
                var news = mapper.mapNewsRequestDtoToNews(newsRequestDto);
                var updatedDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
                news.setLastUpdateDate(updatedDate);
                var savedNews = newsRepository.update(news);
                return mapper.mapNewsToNewsResponseDto(savedNews);
            } else {
                throw new NotFoundException(String.format("News with ID %d not found.", newsRequestDto.id()));
            }
        } else {
            throw new NotFoundException(
                    String.format("Author with ID %d not found.", newsRequestDto.authorId()));
        }
    }

    @Validate(value = "checkNewsId")
    public boolean deleteById(Long id) {
        if (newsRepository.existById(id)) {
            return newsRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("News with ID %d not found.", id));
        }
    }
}
