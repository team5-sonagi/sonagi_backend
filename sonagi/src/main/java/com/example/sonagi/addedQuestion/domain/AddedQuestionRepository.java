package com.example.sonagi.addedQuestion.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddedQuestionRepository extends JpaRepository<AddedQuestion, Long> {
    Optional<AddedQuestion> findByFamilyId(Long familyId);
}
