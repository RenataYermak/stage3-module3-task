package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

public class TagGetAll extends TagBaseCommand implements Command {

    public TagGetAll(BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        super(tagController);
    }

    @Override
    public boolean execute() {
        tagController.readAll().forEach(System.out::println);
        return true;
    }
}
