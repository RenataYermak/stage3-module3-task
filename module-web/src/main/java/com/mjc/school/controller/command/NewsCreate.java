package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

import java.util.Scanner;

public class NewsCreate extends NewsBaseCommand implements Command {

    private final Scanner scanner;

    public NewsCreate(Scanner scanner, BaseController<NewsRequestDto, NewsResponseDto, Long> newsController) {
        super(newsController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.NEWS_TITLE);
        String title = scanner.nextLine();
        System.out.println(Constant.NEWS_CONTENT);
        String content = scanner.nextLine();
        System.out.println(Constant.NEWS_AUTHOR_ID);
        long author_id = Long.parseLong(scanner.nextLine());
        System.out.println(Constant.NEWS_TAG_ID);
        long tagId = Long.parseLong(scanner.nextLine());
        NewsRequestDto newsDtoRequest = new NewsRequestDto(null, title, content, author_id, tagId);
        System.out.println(newsController.create(newsDtoRequest));
        return true;
    }
}
