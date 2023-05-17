package com.mjc.school.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Value
public record AuthorResponseDto(Long id,
                                String name,
                                LocalDateTime createDate,
                                LocalDateTime lastUpdateDate) {

}