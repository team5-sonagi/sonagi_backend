package com.example.sonagi.user.domain;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.family.domain.Family;
import com.example.sonagi.user.dto.UserCreation.Request;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;

	private String name;
	private String bod;
	private String mbti;
	private String hashtag;

	@ManyToOne
	@JoinColumn(name="family_id", referencedColumnName = "id")
	private Family family;

	@OneToMany(mappedBy = "writer")
	private List<AddedQuestion> addedQuestions;

	public static User createUser(Request request, PasswordEncoder passwordEncoder) {
		return User.builder()
			.username(request.getUsername())
			.password(passwordEncoder.encode(request.getPassword()))
			.name(request.getName())
			.bod(request.getBod())
			.mbti(request.getMbti())
			.hashtag(request.getHashtag() == null ? "" : request.getHashtag().toString())
			.build();
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public void addAddedQuestionItem(AddedQuestion addedQuestion) {
		addedQuestions.add(addedQuestion);
	}
}
