package com.mjc.school.controller.command;


import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.Command;
import com.mjc.school.controller.Constant;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;

import java.util.Scanner;

public class AuthorGetById extends AuthorBaseCommand implements Command {

    private final Scanner scanner;

    public AuthorGetById(Scanner scanner, BaseController<AuthorRequestDto, AuthorResponseDto, Long> authorController) {
        super(authorController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constant.AUTHOR_ID);
        long id = Long.parseLong(scanner.nextLine());
        System.out.println(authorController.readById(id));
        return true;
    }
}