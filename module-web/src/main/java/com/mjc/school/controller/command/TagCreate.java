package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

import java.util.Scanner;

public class TagCreate extends TagBaseCommand implements Command {

    private final Scanner scanner;

    public TagCreate(Scanner scanner, BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        super(tagController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.TAG_NAME);
        String name = scanner.nextLine();
        TagRequestDto tagDtoRequest = new TagRequestDto(null, name);
        System.out.println(tagController.create(tagDtoRequest));
        return true;
    }
}
