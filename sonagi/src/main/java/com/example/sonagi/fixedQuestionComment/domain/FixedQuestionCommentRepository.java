package com.example.sonagi.fixedQuestionComment.domain;

import com.example.sonagi.fixed_question.controller.FixedQuestionController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixedQuestionCommentRepository extends JpaRepository<FixedQuestionComment, Long> {
}
