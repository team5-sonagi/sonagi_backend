package com.example.sonagi.fixed_question.service;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionCommentRepository;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndCommentsDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import com.example.sonagi.fixed_question.domain.FixedQuestionRepository;
import com.example.sonagi.fixed_question.dto.QuestionListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FixedQuestionService {

    private final FixedQuestionRepository fixedQuestionRepository;
    private final FixedQuestionCommentRepository fixedQuestionCommentRepository;

    public FixedQuestionDto findByDailyNum(Long dailyNum) {

        Optional<FixedQuestion> optionalFixedQuestion = fixedQuestionRepository.findByDailyNum(dailyNum);
        if (optionalFixedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            FixedQuestion fixedQuestion = optionalFixedQuestion.get();
            return new FixedQuestionDto(fixedQuestion.getId(), fixedQuestion.getContent(), fixedQuestion.getDailyNum());
        }
    }

    public List<QuestionListItemDto> getQList(int dDay) {
        List<QuestionListItemDto> lst = new ArrayList<>();
        for(long i = 0; i<=dDay; i++){
            lst.add(QuestionListItemDto.from(this.findByDailyNum(i)));
        }
        return lst;
    }

    public FixedQuestionAndCommentsDto findQuestionAndCommentsById(Long questionId, Long familyId) {
        Optional<FixedQuestion> optionalFixedQuestion = fixedQuestionRepository.findById(questionId);
        if (optionalFixedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            FixedQuestion fixedQuestion = optionalFixedQuestion.get();
            List<FixedQuestionComment> allByFixedQuestionAndFamilyId = fixedQuestionCommentRepository.findAllByFixedQuestionAndFamilyId(
                fixedQuestion, familyId);
            return new FixedQuestionAndCommentsDto(fixedQuestion.getId(), fixedQuestion.getContent(), fixedQuestion.getDailyNum(), FixedQuestionCommentDto.from(allByFixedQuestionAndFamilyId));
        }
    }
}
