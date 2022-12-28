package com.example.sonagi.addedQuestion.dto;

import com.example.sonagi.addedAnswer.domain.AddedAnswer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddedAnswerDto {
	private Long id;
	private String name;
	private Long userId;
	private String content;
	private LocalDateTime createdAt;

	public static AddedAnswerDto from(AddedAnswer answer) {
		return AddedAnswerDto.builder()
			.id(answer.getId())
			.name(answer.getWriter().getName())
			.userId(answer.getWriter().getId())
			.content(answer.getContent())
			.createdAt(answer.getCreatedAt())
			.build();
	}

	public static List<AddedAnswerDto> from(List<AddedAnswer> answers) {
		List<AddedAnswerDto> list = new ArrayList<>();
		for (AddedAnswer answer : answers) {
			list.add(AddedAnswerDto.from(answer));
		}
		return list;
	}
}
