package com.example.sonagi.fixed_question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedQuestionDto {
    private Long id;
    private String content;
    private Long dailyNum;
}
