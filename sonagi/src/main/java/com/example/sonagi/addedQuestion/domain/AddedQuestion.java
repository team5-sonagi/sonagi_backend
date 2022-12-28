package com.example.sonagi.addedQuestion.domain;

import com.example.sonagi.addedQuestion.dto.AddedQuestionDto;
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
    private User user;

    @Column(nullable = false)
    private String content;

    private Long familyId;

    private LocalDateTime createdAt;

    public static AddedQuestion from(AddedQuestionDto addedQuestionDto, User user) {
        // TODO: 유저 정보를 기반으로 가족 정보를 알아야 함
        return AddedQuestion.builder()
//                .user(user)
                .content(addedQuestionDto.getContent())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
