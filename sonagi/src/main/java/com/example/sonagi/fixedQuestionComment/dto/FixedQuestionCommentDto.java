package com.example.sonagi.fixedQuestionComment.dto;

import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedQuestionCommentDto {
    private Long id;
    private String name;
    private Long userId;
    private Long familyId;
    private String content;
    private LocalDateTime createdAt;

    public static FixedQuestionCommentDto from(FixedQuestionComment comment) {
        return FixedQuestionCommentDto.builder()
                .id(comment.getId())
                .name(comment.getWriter().getName())
                .userId(comment.getWriter().getId())
                .familyId(comment.getFamilyId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }


    public static List<FixedQuestionCommentDto> from(List<FixedQuestionComment> comments) {
        List<FixedQuestionCommentDto> list = new ArrayList<>();
        for (FixedQuestionComment comment : comments) {
            list.add(FixedQuestionCommentDto.from(comment));
        }
        return list;
    }
}
