package com.example.sonagi.addedAnswer.service;

import com.example.sonagi.addedAnswer.domain.AddedAnswer;
import com.example.sonagi.addedAnswer.domain.AddedAnswerRepository;
import com.example.sonagi.addedAnswer.dto.AddedAnswerCreationRequest;
import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestion.domain.AddedQuestionRepository;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddedAnswerService {
	private final AddedAnswerRepository addedAnswerRepository;
	private final AddedQuestionRepository addedQuestionRepository;
	private final UserRepository userRepository;

	public void save(AddedAnswerCreationRequest addedAnswerCreationRequest, User user) {
		long questionId = addedAnswerCreationRequest.getQuestionId();
		AddedQuestion qustion = addedQuestionRepository.findById(questionId)
			.orElseThrow(() -> new RuntimeException(""));

		AddedAnswer answer = AddedAnswer.builder()
			.writer(user)
			.question(qustion)
			.createdAt(LocalDateTime.now())
			.content(addedAnswerCreationRequest.getContent())
			.build();
		addedAnswerRepository.save(answer);

		qustion.addAnswer(answer);
		addedQuestionRepository.save(qustion);

		user.addAddedAnswer(answer);
		userRepository.save(user);
	}
}
