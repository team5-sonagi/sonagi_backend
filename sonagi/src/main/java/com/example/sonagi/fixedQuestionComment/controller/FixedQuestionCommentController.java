package com.example.sonagi.fixedQuestionComment.controller;

import com.example.sonagi.fixedQuestionComment.service.FixedQuestionCommentService;
import com.example.sonagi.fixedQuestionComment.dto.FixedCommentCreationRequest;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FixedQuestionCommentController {
    private final FixedQuestionCommentService fixedQuestionCommentService;
    private final UserService userService;

    // TODO: 얘만으론 컨트롤러에서 필요하지 않을 것으로 보임
    @GetMapping(value="/fixed-question-comment")
    public FixedQuestionCommentDto fixedComment(@RequestParam Long id){
        FixedQuestionCommentDto comment = fixedQuestionCommentService.findById(id);
        return comment;
    }

    @PostMapping("/fixed-question-comment")
    public void saveComment(@RequestBody FixedCommentCreationRequest fixedCommentCreationRequest, @RequestHeader("X-AUTH-TOKEN") String token){
        User user = userService.findUserByToken(token);
        fixedQuestionCommentService.save(fixedCommentCreationRequest, user);
    }

}
