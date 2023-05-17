package com.mjc.school.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public record TagResponseDto(Long id,
                             String name) {
}
