package com.example.sonagi.fixedAnswer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedAnswerDto {
    private Long id;
    private String name;
    private Long userId;
    private Long familyId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
