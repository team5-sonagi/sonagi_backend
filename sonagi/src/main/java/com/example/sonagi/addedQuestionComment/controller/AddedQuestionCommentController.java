package com.example.sonagi.addedQuestionComment.controller;

import com.example.sonagi.addedQuestionComment.dto.AddedCommentCreationRequest;
import com.example.sonagi.addedQuestionComment.dto.AddedQuestionCommentDto;
import com.example.sonagi.addedQuestionComment.service.AddedQuestionCommentService;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AddedQuestionCommentController {

    private final AddedQuestionCommentService addedQuestionCommentService;

    // 댓글 등록
    @PostMapping("/addedQuestionComment")
    public void save(@RequestParam AddedCommentCreationRequest addedCommentCreationRequest) {
        addedQuestionCommentService.save(addedCommentCreationRequest);
    }

    // 댓글 조회
    @GetMapping("/addedQuestionComment")
    public AddedQuestionCommentDto addedComment(@RequestParam Long id) {
        AddedQuestionCommentDto comment = addedQuestionCommentService.findById(id);
        return comment;
    }
}
