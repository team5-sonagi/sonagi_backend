package com.example.sonagi.addedQuestionComment.controller;

import com.example.sonagi.addedQuestionComment.dto.AddedCommentCreationRequest;
import com.example.sonagi.addedQuestionComment.service.AddedQuestionAndCommentsDto;
import com.example.sonagi.addedQuestionComment.service.AddedQuestionCommentService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AddedQuestionCommentController {

    private final AddedQuestionCommentService addedQuestionCommentService;
    private final UserService userService;

    // 댓글 등록
    @PostMapping("/added-question-comment")
    public void save(@RequestBody AddedCommentCreationRequest addedCommentCreationRequest, @RequestHeader("X-AUTH-TOKEN") String token) {
        User user = userService.findUserByToken(token);
        addedQuestionCommentService.save(addedCommentCreationRequest, user);
    }

    // 댓글 조회
    @GetMapping("/added-question-comment")
    public AddedQuestionAndCommentsDto addedComment(@RequestParam(name = "question_id") Long questionId) {
        AddedQuestionAndCommentsDto comments = addedQuestionCommentService.findById(questionId);
        return comments;
    }
}
