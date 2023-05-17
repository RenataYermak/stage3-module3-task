package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

public abstract class NewsBaseCommand {

    protected final BaseController<NewsRequestDto, NewsResponseDto, Long> newsController;

    protected NewsBaseCommand(BaseController<NewsRequestDto, NewsResponseDto, Long> newsController) {
        this.newsController = newsController;
    }
}