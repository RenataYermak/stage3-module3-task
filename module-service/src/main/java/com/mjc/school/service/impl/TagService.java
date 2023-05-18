package com.mjc.school.service.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Tag;
import com.mjc.school.service.BaseService;
import com.mjc.school.service.dto.TagRequestDto;
import com.mjc.school.service.dto.TagResponseDto;
import com.mjc.school.service.exception.NotFoundException;
import com.mjc.school.service.mapper.TagMapper;
import com.mjc.school.service.validation.annotation.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements BaseService<TagRequestDto, TagResponseDto, Long> {

    private final BaseRepository<Tag, Long> tagRepository;
    private final TagMapper mapper;

    @Autowired
    public TagService(BaseRepository<Tag, Long> repository, TagMapper mapper) {
        this.tagRepository = repository;
        this.mapper = mapper;
    }

    @Validate
    @Override
    public List<TagResponseDto> readAll() {
        return mapper.listTagsToTagResponseDto(tagRepository.readAll());
    }

    @Validate(value = "checkTagId")
    @Override
    public TagResponseDto readById(Long id) {
        if (tagRepository.existById(id)) {
            return mapper.mapTagToTagResponseDto(tagRepository.readById(id).get());
        } else {
            throw new NotFoundException(String.format("Tag with ID %d not found.", id));
        }
    }

    @Validate(value = "checkTag")
    @Override
    public TagResponseDto create(TagRequestDto tagRequestDto) {
        var tag = mapper.mapTagRequestDtoToTag(tagRequestDto);
        var createdTag = tagRepository.create(tag);
        return mapper.mapTagToTagResponseDto(createdTag);
    }

    @Validate(value = "checkTag")
    @Override
    public TagResponseDto update(TagRequestDto tagRequestDto) {
        if (tagRepository.existById(tagRequestDto.id())) {
            var tag = mapper.mapTagRequestDtoToTag(tagRequestDto);
            tag.setName(tagRequestDto.name());
            return mapper.mapTagToTagResponseDto(tagRepository.update(tag));
        } else {
            throw new NotFoundException(String.format("Tag with ID %d not found.", tagRequestDto.id()));
        }
    }

    @Validate(value = "checkTagId")
    @Override
    public boolean deleteById(Long id) {
        if (tagRepository.existById(id)) {
            return tagRepository.deleteById(id);
        } else {
            throw new NotFoundException(String.format("Tag with ID %d not found.", id));
        }
    }
}