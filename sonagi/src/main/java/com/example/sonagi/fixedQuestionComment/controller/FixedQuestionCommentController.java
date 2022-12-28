package com.example.sonagi.fixedQuestionComment.controller;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.service.FixedQuestionCommentService;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionCommentRepository;
import com.example.sonagi.fixedQuestionComment.dto.FixedCommentCreationRequest;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FixedQuestionCommentController {
    private final FixedQuestionCommentService fixedQuestionCommentService;

    @GetMapping(value="/fixedQuestionComment")
    public FixedQuestionCommentDto fixedComment(@RequestParam Long id){
        FixedQuestionCommentDto comment = fixedQuestionCommentService.findById(id);
        return comment;
    }

    @PostMapping("/fixedQuestionComment")
    public void saveComment(@RequestParam FixedCommentCreationRequest fixedCommentCreationRequest){
        fixedQuestionCommentService.save(fixedCommentCreationRequest);
    }

}
