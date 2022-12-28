package com.example.sonagi.addedQuestionComment.dto;

import com.example.sonagi.addedQuestionComment.domain.AddedQuestionComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddedQuestionCommentDto {
    private Long id;
    private String name;
    private Long userId;
    @NotBlank(message = "content cannot be blank")
    private String content;
    private LocalDateTime createdAt;

    public static AddedQuestionCommentDto from(AddedQuestionComment comment) {
        return AddedQuestionCommentDto.builder()
                .id(comment.getId())
                .name(comment.getWriter().getUsername())
                .userId(comment.getWriter().getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .build();
    }

    public static List<AddedQuestionCommentDto> from(List<AddedQuestionComment> addedComments) {
        List<AddedQuestionCommentDto> list = new ArrayList<>();
        for (AddedQuestionComment addedComment : addedComments) {
            list.add(AddedQuestionCommentDto.from(addedComment));
        }
        return list;
    }
}
