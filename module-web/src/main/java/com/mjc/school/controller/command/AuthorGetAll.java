package com.mjc.school.controller.command;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;

public class AuthorGetAll extends AuthorBaseCommand implements Command {

    public AuthorGetAll(BaseController<AuthorRequestDto, AuthorResponseDto, Long> authorController) {
        super(authorController);
    }

    @Override
    public boolean execute() {
        authorController.readAll().forEach(System.out::println);
        return true;
    }
}