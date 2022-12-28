package com.example.sonagi.fixed_question.dto;

import com.example.sonagi.fixed_question.domain.FixedQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionListItemDto {
    private Long id;
    private String content;

    public static QuestionListItemDto from(FixedQuestionDto fixedQuestionDto) {
        return QuestionListItemDto.builder()
                .id(fixedQuestionDto.getId())
                .content(fixedQuestionDto.getContent())
                .build();
    }
}
