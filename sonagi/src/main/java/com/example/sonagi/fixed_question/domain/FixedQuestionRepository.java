package com.example.sonagi.fixed_question.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FixedQuestionRepository extends JpaRepository<FixedQuestion, Long> {
    Optional<FixedQuestion> findByDailyNum(long dailyNum);
}
