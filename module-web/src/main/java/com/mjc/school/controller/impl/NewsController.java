package com.mjc.school.controller.impl;


import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NewsController implements BaseController<NewsRequestDto, NewsResponseDto, Long> {

    private final BaseService<NewsRequestDto, NewsResponseDto, Long> newsService;

    @Autowired
    public NewsController(BaseService<NewsRequestDto, NewsResponseDto, Long> newsService) {
        this.newsService = newsService;
    }

    @Override
    public List<NewsResponseDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public NewsResponseDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public NewsResponseDto create(NewsRequestDto newsRequestDto) {
        return newsService.create(newsRequestDto);
    }

    @Override
    public NewsResponseDto update(NewsRequestDto newsRequestDto) {
        return newsService.update(newsRequestDto);
    }

    @Override
    public boolean deleteById(Long id) {
        return newsService.deleteById(id);
    }
}