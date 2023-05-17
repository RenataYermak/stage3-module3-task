package com.mjc.school.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public record NewsRequestDto(Long id,
                             String title,
                             String content,
                             Long authorId,
                             Long tagId) {

}
