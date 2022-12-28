package com.example.sonagi.addedAnswer.domain;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.user.domain.User;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AddedAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String content;
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User writer;

	@ManyToOne
	@JoinColumn(name = "question_id", referencedColumnName = "aq_id")
	private AddedQuestion question;
}
