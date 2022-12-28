package com.example.sonagi.fixed_question.controller;

import com.example.sonagi.family.service.FamilyService;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndAnswersDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndCommentsDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import com.example.sonagi.fixed_question.dto.QuestionListItemDto;
import com.example.sonagi.fixed_question.service.FixedQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FixedQuestionController {

    private final FixedQuestionService fixedQuestionService;
    private final FamilyService familyService;

    @GetMapping(value="/fixedQuestion/{id}")
    public FixedQuestionDto question(@PathVariable Long id){
        FixedQuestionDto dailyQuestion = fixedQuestionService.findByDailyNum(id);
        return dailyQuestion;
    }

    @GetMapping(value="/fixedQuestion")
    public FixedQuestionDto famInfo(@RequestParam Long familyId){
        int dDay = familyService.getDDay(familyId);
        return fixedQuestionService.findByDailyNum((long) dDay);
    }

    @GetMapping(value = "/fixedQuestion/list")
    public List<QuestionListItemDto> qList(@RequestParam Long familyId){
        int dDay = familyService.getDDay(familyId);
        return fixedQuestionService.getQList(dDay);
    }

    @GetMapping(value = "/fixedQuestion/comments/{id}")
    public FixedQuestionAndCommentsDto fixedComments(@PathVariable Long id){
        return fixedQuestionService.findQuestionAndCommentsById(id);
    }

    @GetMapping(value = "/fixedQuestion/answers/{id}")
    public FixedQuestionAndAnswersDto fixedAnswers(@PathVariable Long id){
        return fixedQuestionService.findQuestionAndAnswersById(id);
    }
}
