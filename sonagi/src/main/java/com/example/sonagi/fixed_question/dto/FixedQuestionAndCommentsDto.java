package com.example.sonagi.fixed_question.dto;

import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedQuestionAndCommentsDto {
    private Long id;
    private String content;
    private Long dailyNum;
    private List<FixedQuestionCommentDto> comments;
}
