package com.example.sonagi.addedQuestion.controller;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestion.dto.AddedQuestionDto;
import com.example.sonagi.addedQuestion.service.AddedQuestionService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AddedQuestionController {

    private final AddedQuestionService addedQuestionService;
    private final UserService userService;

    // 추가 질문 등록
    @PostMapping("/addedquestion")
    public Long save(@RequestBody AddedQuestionDto addedQuestionDto, @RequestHeader("X-AUTH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
        return addedQuestionService.save(addedQuestionDto, user);
    }

    // 추가 질문 조희
    @GetMapping("/addedquestion/{familyId}")
    public AddedQuestion view(@PathVariable("familyCode") Long familyId) {
        return addedQuestionService.findByFamilyId(familyId);
    }

}
