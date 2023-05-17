package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;

public abstract class TagBaseCommand {

    protected final BaseController<TagRequestDto, TagResponseDto, Long> tagController;

    protected TagBaseCommand(BaseController<TagRequestDto, TagResponseDto, Long> tagController) {
        this.tagController = tagController;
    }
}
