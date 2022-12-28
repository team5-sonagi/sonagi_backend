package com.example.sonagi.fixedAnswer.domain;

import com.example.sonagi.fixed_question.domain.FixedQuestion;
import com.example.sonagi.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FixedAnswer")
public class FixedAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private Long familyId;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="fixedQuestionId", referencedColumnName = "id")
    private FixedQuestion fixedQuestion;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User writer;

}
