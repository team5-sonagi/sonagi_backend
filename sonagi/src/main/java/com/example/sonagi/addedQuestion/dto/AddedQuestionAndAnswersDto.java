package com.example.sonagi.addedQuestion.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddedQuestionAndAnswersDto {
	private Long id;
	private String question;
	private List<AddedAnswerDto> answers;
}
