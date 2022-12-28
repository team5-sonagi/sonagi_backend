package com.example.sonagi.user.domain;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
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

	@OneToMany(mappedBy = "writer")
	private List<FixedQuestionComment> fixedComments;
}
