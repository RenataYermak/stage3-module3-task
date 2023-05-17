package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;

public abstract class AuthorBaseCommand {

    protected final BaseController<AuthorRequestDto, AuthorResponseDto, Long> authorController;

    protected AuthorBaseCommand(BaseController<AuthorRequestDto, AuthorResponseDto, Long> authorController) {
        this.authorController = authorController;
    }
}