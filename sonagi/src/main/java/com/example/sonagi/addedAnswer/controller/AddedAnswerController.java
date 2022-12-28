package com.example.sonagi.addedAnswer.controller;

import com.example.sonagi.addedAnswer.dto.AddedAnswerCreationRequest;
import com.example.sonagi.addedAnswer.service.AddedAnswerService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import com.example.sonagi.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AddedAnswerController {
	private final AddedAnswerService addedAnswerService;
	private final UserService userService;

	@PostMapping("/added-answer")
	public void saveAddedAnswer(@RequestBody @Valid AddedAnswerCreationRequest addedAnswerCreationRequest, @RequestHeader("X-AUTH-TOKEN") String token) {
		User user = userService.findUserByToken(token);
		addedAnswerService.save(addedAnswerCreationRequest, user);
	}
}
