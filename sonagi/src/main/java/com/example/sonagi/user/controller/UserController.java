package com.example.sonagi.user.controller;

import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.dto.FamilyMember;
import com.example.sonagi.user.dto.UserCreation;
import com.example.sonagi.user.dto.UserLogin;
import com.example.sonagi.user.service.UserService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@GetMapping("/family-info")
	public List<FamilyMember.Response> getFamilyMembersInfo(@RequestHeader("X-AUTH-TOKEN") String token) {
		User user = userService.findUserByToken(token);
		return userService.getFamilyMembersInfo(user);
	}
}
