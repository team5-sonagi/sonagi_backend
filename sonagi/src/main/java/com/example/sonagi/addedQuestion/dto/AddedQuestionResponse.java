package com.example.sonagi.addedQuestion.dto;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddedQuestionResponse {
	private Long id;
	private String username;
	private Long userId;
	private String content;
	private Long familyId;
	private LocalDateTime createdAt;

	public static AddedQuestionResponse from(AddedQuestion addedQuestion) {
		return AddedQuestionResponse.builder()
			.id(addedQuestion.getId())
			.username(addedQuestion.getWriter().getUsername())
			.userId(addedQuestion.getWriter().getId())
			.content(addedQuestion.getContent())
			.familyId(addedQuestion.getFamilyId())
			.createdAt(addedQuestion.getCreatedAt())
			.build();
	}

	public static List<AddedQuestionResponse> from(List<AddedQuestion> addedQuestions) {
		List<AddedQuestionResponse> list = new ArrayList<>();
		for (AddedQuestion question : addedQuestions) {
			list.add(AddedQuestionResponse.from(question));
		}
		return list;
	}
}
