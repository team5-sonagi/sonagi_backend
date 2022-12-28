package com.example.sonagi.user.domain;

import com.example.sonagi.addedAnswer.domain.AddedAnswer;
import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionComment;
import com.example.sonagi.family.domain.Family;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.user.dto.UserCreation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
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
	private List<FixedQuestionComment> fixedComments;

	@OneToMany(mappedBy = "writer")
	private List<AddedQuestion> addedQuestions;

	@OneToMany(mappedBy = "writer")
	private List<AddedQuestionComment> addedQuestionComments;

	@OneToMany(mappedBy = "writer")
	private List<AddedAnswer> addedAnswers;

	public static User createUser(UserCreation.Request request, PasswordEncoder passwordEncoder) {
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

	public void addAddedQuestion(AddedQuestion addedQuestion) {
		addedQuestions.add(addedQuestion);
	}

	public void addFixedComment(FixedQuestionComment fixedQuestionComment) {
		fixedComments.add(fixedQuestionComment);
	}

	public void addAddedAnswer(AddedAnswer answer) {
		addedAnswers.add(answer);
	}

	public void addAddedComment(AddedQuestionComment comment) {
		addedQuestionComments.add(comment);
	}
}
