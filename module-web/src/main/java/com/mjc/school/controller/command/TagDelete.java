package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

import java.util.Scanner;

public class TagDelete extends TagBaseCommand implements Command {

    private final Scanner scanner;

    public TagDelete(Scanner scanner, BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        super(tagController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.TAG_ID);
        long id = Long.parseLong(scanner.nextLine());
        tagController.deleteById(id);
        return true;
    }
}
