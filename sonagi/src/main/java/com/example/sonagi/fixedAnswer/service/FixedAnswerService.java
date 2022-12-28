package com.example.sonagi.fixedAnswer.service;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
import com.example.sonagi.fixedAnswer.domain.FixedAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FixedAnswerService {
    private final FixedAnswerRepository fixedAnswerRepository;
}
