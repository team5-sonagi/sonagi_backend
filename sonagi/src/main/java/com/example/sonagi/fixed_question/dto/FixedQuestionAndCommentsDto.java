package com.example.sonagi.fixed_question.dto;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedQuestionAndCommentsDto {
    private Long id;
    private String content;
    private Long dailyNum;
    private List<FixedQuestionCommentDto> comments;
}
