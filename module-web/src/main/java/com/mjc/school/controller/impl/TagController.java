package com.mjc.school.controller.impl;

import com.mjc.school.controller.BaseController;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.NewsRequestDto;
import com.mjc.school.service.dto.NewsResponseDto;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;
import com.mjc.school.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TagController implements BaseController<TagRequestDto, TagResponseDto, Long> {

    private final BaseService<TagRequestDto, TagResponseDto, Long> tagService;

    @Autowired
    public TagController(BaseService<TagRequestDto, TagResponseDto, Long> tagService) {
        this.tagService = tagService;
    }

    @Override
    public List<TagResponseDto> readAll() {
        return tagService.readAll();
    }

    @Override
    public TagResponseDto readById(Long id) {
        return tagService.readById(id);
    }

    @Override
    public TagResponseDto create(TagRequestDto tagRequestDto) {
        return tagService.create(tagRequestDto);
    }

    @Override
    public TagResponseDto update(TagRequestDto tagRequestDto) {
        return tagService.update(tagRequestDto);
    }

    @Override
    public boolean deleteById(Long id) {
        return tagService.deleteById(id);
    }
}
