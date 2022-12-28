package com.example.sonagi.fixedAnswer.domain;

import com.example.sonagi.fixed_question.domain.FixedQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedAnswerRepository extends JpaRepository<FixedAnswer, Long> {
	List<FixedAnswer> findAllByFixedQuestionAndFamilyId(FixedQuestion fixedQuestion, Long familyId);
}
