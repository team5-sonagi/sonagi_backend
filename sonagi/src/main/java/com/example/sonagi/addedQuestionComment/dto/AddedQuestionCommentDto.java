package com.example.sonagi.addedQuestionComment.dto;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestionComment.domain.AddedQuestionComment;
import com.example.sonagi.user.domain.User;
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
    private User userId;
    private AddedQuestion addedQuestion;
    @NotBlank(message = "content cannot be blank")
    private String content;
    private LocalDateTime createdAt;

    public static AddedQuestionCommentDto from(AddedQuestionComment comment, User user) {
        return AddedQuestionCommentDto.builder()
                .id(comment.getId())
                .userId(comment.getUserId())
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
