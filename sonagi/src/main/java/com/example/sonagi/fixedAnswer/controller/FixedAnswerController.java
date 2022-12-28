package com.example.sonagi.fixedAnswer.controller;

import com.example.sonagi.fixedAnswer.dto.FixedAnswerDto;
import com.example.sonagi.fixedAnswer.dto.FixedAnswerRequest;
import com.example.sonagi.fixedAnswer.service.FixedAnswerService;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FixedAnswerController {
    private final FixedAnswerService fixedAnswerService;

    @PostMapping("/fixedAnswer")
    public void saveAnswer(@RequestBody FixedAnswerRequest fixedAnswerRequest){
        fixedAnswerService.save(fixedAnswerRequest);

    }

}
