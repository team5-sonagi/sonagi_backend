package com.example.sonagi.fixedQuestionComment.controller;

import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixedQuestionComment.service.FixedQuestionCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FixedQuestionCommentController {
    private final FixedQuestionCommentService fixedQuestionCommentService;

    @GetMapping(value="/fixed-question-comment")
    public FixedQuestionCommentDto fixedComment(@RequestParam Long id){
        FixedQuestionCommentDto comment = fixedQuestionCommentService.findById(id);
        return comment;
    }
}
