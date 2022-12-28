package com.example.sonagi.addedQuestion.domain;

import com.example.sonagi.addedQuestion.dto.AddedQuestionRequest;
import com.example.sonagi.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AddedQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User writer;

    @Column(nullable = false)
    private String content;

    private Long familyId;

    private LocalDateTime createdAt;

    public static AddedQuestion from(AddedQuestionRequest addedQuestionRequest, User user) {
        AddedQuestion question = AddedQuestion.builder()
            .writer(user)
            .familyId(user.getFamily().getId())
            .content(addedQuestionRequest.getContent())
            .createdAt(LocalDateTime.now())
            .build();
        user.addAddedQuestion(question);
        return question;
    }
}
