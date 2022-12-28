package com.example.sonagi.addedQuestion.controller;

import com.example.sonagi.addedQuestion.dto.AddedQuestionRequest;
import com.example.sonagi.addedQuestion.dto.AddedQuestionResponse;
import com.example.sonagi.addedQuestion.dto.AddedQuestionAndAnswersDto;
import com.example.sonagi.addedQuestion.service.AddedQuestionService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AddedQuestionController {

    private final AddedQuestionService addedQuestionService;
    private final UserService userService;

    // 추가 질문 등록
    @PostMapping("/added-question")
    public Long save(@RequestBody AddedQuestionRequest addedQuestionRequest, @RequestHeader("X-AUTH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
        return addedQuestionService.save(addedQuestionRequest, user);
    }

    // 추가 질문 조희
    @GetMapping("/added-question")
    public List<AddedQuestionResponse> view(@RequestHeader("X-AUTH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
        return addedQuestionService.findAllByFamilyId(user.getFamily().getId());
    }

    @GetMapping("/added-question/{id}/answers")
    public AddedQuestionAndAnswersDto searchAddedAnswers(@PathVariable Long id, @RequestHeader("X-AUTH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
        return addedQuestionService.findQuestionAndAnswersById(id);
    }


}
