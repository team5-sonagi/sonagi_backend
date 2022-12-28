package com.example.sonagi.addedQuestionComment.service;

import com.example.sonagi.addedQuestionComment.dto.AddedQuestionCommentDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddedQuestionAndCommentsDto {
	private Long id;
	private String content;
	private List<AddedQuestionCommentDto> comments;
}
