package com.example.sonagi.fixedQuestionComment.domain;

import com.example.sonagi.fixed_question.domain.FixedQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedQuestionCommentRepository extends JpaRepository<FixedQuestionComment, Long> {

	List<FixedQuestionComment> findAllByFixedQuestionAndFamilyId(FixedQuestion fixedQuestion, Long familyId);
}
