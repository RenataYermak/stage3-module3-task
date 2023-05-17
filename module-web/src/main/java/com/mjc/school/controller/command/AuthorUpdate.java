package com.mjc.school.controller.command;


import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;

import java.util.Scanner;

public class AuthorUpdate extends AuthorBaseCommand implements Command {

    private final Scanner scanner;

    public AuthorUpdate(Scanner scanner, BaseController<AuthorRequestDto, AuthorResponseDto, Long> authorController) {
        super(authorController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.AUTHOR_ID);
        long id = Long.parseLong(scanner.nextLine());
        System.out.println(Constant.AUTHOR_NAME);
        String name = scanner.nextLine();
        AuthorRequestDto authorDtoRequest = new AuthorRequestDto(id, name);
        System.out.println(authorController.update(authorDtoRequest));
        return true;
    }
}