package com.example.sonagi.fixedAnswer.service;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
import com.example.sonagi.fixedAnswer.domain.FixedAnswerRepository;
import com.example.sonagi.fixedAnswer.dto.FixedAnswerRequest;
import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.fixed_question.domain.FixedQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FixedAnswerService {
    private final FixedAnswerRepository fixedAnswerRepository;
    private final FixedQuestionRepository fixedQuestionRepository;

    public void save(FixedAnswerRequest fixedAnswerRequest) {
        Optional<FixedQuestion> optionalFixedQuestion = fixedQuestionRepository.findById(fixedAnswerRequest.getQuestionId());
        //TODO: User, FamilyId X
        if(optionalFixedQuestion.isEmpty()){
            throw new RuntimeException();
        }else{
            FixedQuestion fixedQuestion = optionalFixedQuestion.get();
            FixedAnswer fixedAnswer = FixedAnswer.builder()
                    .fixedQuestion(fixedQuestion)
                    .content(fixedAnswerRequest.getContent())
                    .createdAt(LocalDateTime.now())
                    .build();
            fixedAnswerRepository.save(fixedAnswer);
            fixedQuestion.addFixedAnswer(fixedAnswer);
        }

    }
}
