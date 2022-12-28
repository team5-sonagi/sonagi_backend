package com.example.sonagi.addedQuestionComment.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddedQuestionCommentRepository extends JpaRepository<AddedQuestionComment, Long> {
}
