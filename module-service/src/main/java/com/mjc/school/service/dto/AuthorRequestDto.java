package com.mjc.school.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public record AuthorRequestDto(Long id,
                               String name) {

}
