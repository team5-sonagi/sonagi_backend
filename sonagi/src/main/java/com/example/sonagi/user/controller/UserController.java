package com.example.sonagi.user.controller;

import com.example.sonagi.user.dto.UserCreation;
import com.example.sonagi.user.dto.UserLogin;
import com.example.sonagi.user.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public UserCreation.Response register(@RequestBody @Valid UserCreation.Request creationRequest) {
		return userService.register(creationRequest);
	}

	@PostMapping("/login")
	public String register(@RequestBody @Valid UserLogin.Request loginRequest) {
		return userService.login(loginRequest);
	}
}
