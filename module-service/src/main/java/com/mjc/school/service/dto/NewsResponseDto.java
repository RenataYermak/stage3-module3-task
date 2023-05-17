package com.mjc.school.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public record NewsResponseDto(Long id,
                              String title,
                              String content,
                              LocalDateTime createDate,
                              LocalDateTime lastUpdateDate,
                              AuthorResponseDto authorDto,
                              List<Long> tagIds ) {

}