package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

import java.util.Scanner;

public class TagUpdate extends TagBaseCommand implements Command {

    private final Scanner scanner;

    public TagUpdate(Scanner scanner, BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        super(tagController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.TAG_ID);
        var tagId = scanner.nextLine();
        System.out.println(Constant.TAG_NAME);
        var name = scanner.nextLine();
        var tagDtoRequest = new TagRequestDto(Long.parseLong(tagId), name);
        System.out.println(tagController.update(tagDtoRequest));
        return true;
    }
}