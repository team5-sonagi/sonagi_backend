package com.example.sonagi.fixedQuestionComment.service;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionCommentRepository;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.fixed_question.dto.FixedQuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FixedQuestionCommentService {
    private final FixedQuestionCommentRepository fixedQuestionCommentRepository;
    public FixedQuestionCommentDto findById(Long id) {
        Optional<FixedQuestionComment> optionalFixedQuestionComment = fixedQuestionCommentRepository.findById(id);
        if (optionalFixedQuestionComment.isEmpty()) {
            throw new RuntimeException();
        } else {
            FixedQuestionComment fixedQuestionComment = optionalFixedQuestionComment.get();
            return new FixedQuestionCommentDto(fixedQuestionComment.getId(), fixedQuestionComment.getWriter().getName(), fixedQuestionComment.getWriter().getId(), fixedQuestionComment.getFamilyId(), fixedQuestionComment.getContent(), fixedQuestionComment.getCreatedAt());
        }
    }
}
