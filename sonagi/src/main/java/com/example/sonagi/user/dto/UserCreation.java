package com.example.sonagi.user.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserCreation {
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class Request {
		@NotNull
		private String username;
		@NotNull
		private String password;
		@NotNull
		private String name;
		private String bod;
		private String mbti;
		private List<String> hashtag;
		private String familyCode;
	}

	@Getter
	@AllArgsConstructor
	public static class Response {
		private String familyCode;
	}
}
