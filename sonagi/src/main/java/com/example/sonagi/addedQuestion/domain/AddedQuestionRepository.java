package com.example.sonagi.addedQuestion.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddedQuestionRepository extends JpaRepository<AddedQuestion, Long> {
    List<AddedQuestion> findAllByFamilyId(Long familyId);
}
