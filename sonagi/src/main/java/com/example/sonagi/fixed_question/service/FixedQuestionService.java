package com.example.sonagi.fixed_question.service;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
import com.example.sonagi.fixedAnswer.domain.FixedAnswerRepository;
import com.example.sonagi.fixedAnswer.dto.FixedAnswerByYearDto;
import com.example.sonagi.fixedAnswer.dto.FixedAnswerDto;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionCommentRepository;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndAnswersDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndCommentsDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import com.example.sonagi.fixed_question.domain.FixedQuestionRepository;
import com.example.sonagi.fixed_question.dto.QuestionListItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class FixedQuestionService {

    private final FixedQuestionRepository fixedQuestionRepository;
    private final FixedQuestionCommentRepository fixedQuestionCommentRepository;
    private final FixedAnswerRepository fixedAnswerRepository;

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

    public FixedQuestionAndAnswersDto findQuestionAndAnswersById(Long questionId, Long familyId) {
        Optional<FixedQuestion> optionalFixedQuestion = fixedQuestionRepository.findById(questionId);
        if (optionalFixedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            FixedQuestion fixedQuestion = optionalFixedQuestion.get();
            List<FixedAnswer> fixedAnswers = fixedAnswerRepository.findAllByFixedQuestionAndFamilyId(
                fixedQuestion, familyId);
            HashMap<Integer, List<FixedAnswer>> hashMap = new HashMap<>();
            for (FixedAnswer answer : fixedAnswers) {
                LocalDateTime createdAt = answer.getCreatedAt();
                int year = createdAt.getYear();
                if(hashMap.containsKey(year)){
                    List<FixedAnswer> list = hashMap.get(year);
                    list.add(answer);
                }else{
                    List<FixedAnswer> list = new ArrayList<>();
                    list.add(answer);
                    hashMap.put(year,list);
                }
            }
            List<FixedAnswerByYearDto> answers = new ArrayList<>();
            for(Map.Entry<Integer, List<FixedAnswer>> entry : hashMap.entrySet()){
                answers.add(new FixedAnswerByYearDto(entry.getKey(), FixedAnswerDto.from(entry.getValue())));
            }
            return new FixedQuestionAndAnswersDto(fixedQuestion.getId(), fixedQuestion.getContent(), fixedQuestion.getDailyNum(), answers);
        }
    }
}
