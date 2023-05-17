package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.dto.AuthorRequestDto;
import com.mjc.school.service.dto.AuthorResponseDto;
import com.mjc.school.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class AuthorController implements BaseController<AuthorRequestDto, AuthorResponseDto, Long> {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public List<AuthorResponseDto> readAll() {
        return authorService.readAll();
    }

    @Override
    public AuthorResponseDto readById(Long id) {
        return authorService.readById(id);
    }

    @Override
    public AuthorResponseDto create(AuthorRequestDto authorRequestDto) {
        return authorService.create(authorRequestDto);
    }

    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto) {
        return authorService.update(authorRequestDto);
    }

    @Override
    public boolean deleteById(Long id) {
        return authorService.deleteById(id);
    }
}