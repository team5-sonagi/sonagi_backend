package com.example.sonagi.addedQuestionComment.service;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestion.domain.AddedQuestionRepository;
import com.example.sonagi.addedQuestion.dto.AddedAnswerDto;
import com.example.sonagi.addedQuestion.dto.AddedQuestionAndAnswersDto;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionComment;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionCommentRepository;
import com.example.sonagi.addedQuestionComment.dto.AddedCommentCreationRequest;
import com.example.sonagi.addedQuestionComment.dto.AddedQuestionCommentDto;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddedQuestionCommentService {
    private final AddedQuestionCommentRepository addedQuestionCommentRepository;
    private final AddedQuestionRepository addedQuestionRepository;
    private final UserRepository userRepository;

    public Long save(AddedCommentCreationRequest addedCommentCreationRequest, User user) {
        Optional<AddedQuestion> optionalAddedQuestion = addedQuestionRepository.findById(addedCommentCreationRequest.getQuestionId());
        if (optionalAddedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            AddedQuestion question = optionalAddedQuestion.get();
            AddedQuestionComment comment = AddedQuestionComment.builder()
                .writer(user)
                .question(question)
                .content(addedCommentCreationRequest.getContent())
                .createdAt(LocalDateTime.now())
                .build();
            addedQuestionCommentRepository.save(comment);

            question.addComment(comment);
            addedQuestionRepository.save(question);

            user.addAddedComment(comment);
            userRepository.save(user);

            return comment.getId();
        }
    }

    public AddedQuestionAndCommentsDto findById(Long questionId) {
        Optional<AddedQuestion> optionalAddedQuestion = addedQuestionRepository.findById(questionId);
        if (optionalAddedQuestion.isEmpty()) {
            throw new RuntimeException();
        } else {
            AddedQuestion question = optionalAddedQuestion.get();
            return AddedQuestionAndCommentsDto.builder()
                .id(questionId)
                .content(question.getContent())
                .comments(AddedQuestionCommentDto.from(question.getComments()))
                .build();
        }
    }
}
