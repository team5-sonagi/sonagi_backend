package com.example.sonagi.addedQuestionComment.service;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionComment;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionCommentRepository;
import com.example.sonagi.addedQuestionComment.dto.AddedCommentCreationRequest;
import com.example.sonagi.addedQuestionComment.dto.AddedQuestionCommentDto;
import com.example.sonagi.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddedQuestionCommentService {
    private final AddedQuestionCommentRepository addedQuestionCommentRepository;

    public Long save(AddedCommentCreationRequest addedCommentCreationRequest) {
        Optional<AddedQuestionComment> optionalAddedQuestion = addedQuestionCommentRepository.findById(addedCommentCreationRequest.getQuestionId());
        if (optionalAddedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            AddedQuestionComment addedQuestionComment = optionalAddedQuestion.get();
            return new AddedQuestionCommentDto(
                    addedQuestionComment.getId(),
                    addedQuestionComment.getUserId(),
                    addedQuestionComment.getAddedQuestion(),
                    addedQuestionComment.getContent(),
                    addedQuestionComment.getCreatedAt()
            );
        }
    }

    public AddedQuestionCommentDto findById(Long id) {
        Optional<AddedQuestionComment> optionalAddedQuestionComment = addedQuestionCommentRepository.findById(id);
        if (optionalAddedQuestionComment.isEmpty()) {
            throw new RuntimeException();
        } else {
            AddedQuestionComment addedQuestionComment = optionalAddedQuestionComment.get();
            return new AddedQuestionCommentDto(
                    addedQuestionComment.getId(),
                    addedQuestionComment.getUserId(),
                    addedQuestionComment.getAddedQuestion(),
                    addedQuestionComment.getContent(),
                    addedQuestionComment.getCreatedAt()
            );
        }
    }
}
