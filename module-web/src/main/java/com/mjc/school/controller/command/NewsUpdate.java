package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

import java.util.Scanner;

public class NewsUpdate extends NewsBaseCommand implements Command {

    private final Scanner scanner;

    public NewsUpdate(Scanner scanner, BaseController<NewsRequestDto, NewsResponseDto, Long> newsController) {
        super(newsController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.NEWS_ID);
        String newsId = scanner.nextLine();
        System.out.println(Constant.NEWS_TITLE);
        String title = scanner.nextLine();
        System.out.println(Constant.NEWS_CONTENT);
        String content = scanner.nextLine();
        System.out.println(Constant.NEWS_AUTHOR_ID);
        String authorId = scanner.nextLine();
        System.out.println(Constant.NEWS_TAG_ID);
        String tagId = scanner.nextLine();
        NewsRequestDto newsDtoRequest = new NewsRequestDto(Long.parseLong(newsId), title, content, Long.parseLong(authorId), Long.parseLong(tagId));
        System.out.println(newsController.update(newsDtoRequest));
        return true;
    }
}