package com.example.sonagi.fixedAnswer.controller;

import com.example.sonagi.fixedAnswer.service.FixedAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FixedAnswerController {
    private final FixedAnswerService fixedAnswerService;

}
