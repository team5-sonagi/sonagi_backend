package com.example.sonagi.addedAnswer.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddedAnswerCreationRequest {
	@NotNull
	private String content;
	@NotNull
	private Long questionId;
}
