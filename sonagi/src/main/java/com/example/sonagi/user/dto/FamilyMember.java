package com.example.sonagi.user.dto;

import com.example.sonagi.user.domain.User;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class FamilyMember {
	@Getter
	@Builder
	@AllArgsConstructor
	public static class Response {
		private long id;
		private String name;
		private String bod;
		private String mbti;
		private String hashtag;

		public static Response from(User user) {
			return Response.builder()
				.id(user.getId())
				.name(user.getName())
				.bod(user.getBod())
				.mbti(user.getMbti())
				.hashtag(user.getHashtag())
				.build();
		}

		public static List<Response> from(List<User> userList) {
			List<Response> list = new ArrayList<>();
			for (User user : userList) {
				list.add(Response.from(user));
			}
			return list;
		}
	}

}
