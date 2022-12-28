package com.example.sonagi.fixedAnswer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedAnswerRequest {
    private String content;
    private Long questionId;
}
