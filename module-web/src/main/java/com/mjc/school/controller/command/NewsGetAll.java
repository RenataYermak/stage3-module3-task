package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

public class NewsGetAll extends NewsBaseCommand implements Command {

    public NewsGetAll(BaseController<NewsRequestDto, NewsResponseDto, Long> newsController) {
        super(newsController);
    }

    @Override
    public boolean execute() {
        newsController.readAll().forEach(System.out::println);
        return true;
    }
}