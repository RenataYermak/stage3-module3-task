package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

import java.util.Scanner;

public class TagGetById extends TagBaseCommand implements Command {

    private final Scanner scanner;
    public TagGetById(Scanner scanner, BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        super(tagController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.NEWS_ID);
        var id = Long.parseLong(scanner.nextLine());
        System.out.println(tagController.readById(id));
        return true;
    }
}
