package com.example.sonagi.fixedQuestionComment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedCommentCreationRequest {
    private String content;
    private Long questionId;
}
