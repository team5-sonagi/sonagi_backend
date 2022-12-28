package com.example.sonagi.addedQuestionComment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddedCommentCreationRequest {
    private String newContent;
    private Long questionId;
}
