package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;

import java.util.Scanner;

public class NewsGetById extends NewsBaseCommand implements Command {

    private final Scanner scanner;
    public NewsGetById(Scanner scanner, BaseController<NewsRequestDto, NewsResponseDto, Long> newsController) {
        super(newsController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.NEWS_ID);
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println(newsController.readById(id));
        return true;
    }
}