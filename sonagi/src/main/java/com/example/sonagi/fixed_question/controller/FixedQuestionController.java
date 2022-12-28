package com.example.sonagi.fixed_question.controller;

import com.example.sonagi.family.service.FamilyService;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndAnswersDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionAndCommentsDto;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import com.example.sonagi.fixed_question.dto.QuestionListItemDto;
import com.example.sonagi.fixed_question.service.FixedQuestionService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FixedQuestionController {

    private final FixedQuestionService fixedQuestionService;
    private final FamilyService familyService;
    private final UserService userService;

    @GetMapping(value= "/fixed-question/daily/{dailyNum}")
    public FixedQuestionDto question(@PathVariable Long dailyNum){
        FixedQuestionDto dailyQuestion = fixedQuestionService.findByDailyNum(dailyNum);
        return dailyQuestion;
    }

    @GetMapping(value="/fixed-question/daily")
    public FixedQuestionDto famInfo(@RequestHeader("X-AUTH-TOKEN") String token){
        User user = userService.findUserByToken(token);
        int dDay = familyService.getDDay(user.getFamily());
        return fixedQuestionService.findByDailyNum((long) dDay);
    }

    @GetMapping(value = "/fixed-question/daily/list")
    public List<QuestionListItemDto> qList(@RequestHeader("X-AUTH-TOKEN") String token){
        User user = userService.findUserByToken(token);
        int dDay = familyService.getDDay(user.getFamily());
        return fixedQuestionService.getQList(dDay);
    }

    @GetMapping(value = "/fixed-question/{questionId}/comments")
    public FixedQuestionAndCommentsDto fixedComments(@PathVariable Long questionId, @RequestHeader("X-AUTH-TOKEN") String token){
        User user = userService.findUserByToken(token);
        return fixedQuestionService.findQuestionAndCommentsById(questionId, user.getFamily().getId());
    }

    @GetMapping(value = "/fixedQuestion/answers/{id}")
    public FixedQuestionAndAnswersDto fixedAnswers(@PathVariable Long id, @RequestHeader("X-AUTH-TOKEN") String token){
        User user = userService.findUserByToken(token);
        return fixedQuestionService.findQuestionAndAnswersById(id, user.getFamily().getId());
    }
}
