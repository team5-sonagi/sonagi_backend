package com.example.sonagi.addedQuestionComment.domain;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.hibernate.mapping.ToOne;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AddedQuestionComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cmt_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "aq_id", referencedColumnName = "aq_id")
    private AddedQuestion question;

    @Column(nullable = false, length = 1000)
    private String content;

    @Column
    private LocalDateTime createdAt;
}
