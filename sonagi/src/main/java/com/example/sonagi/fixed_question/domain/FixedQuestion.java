package com.example.sonagi.fixed_question.domain;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
import com.example.sonagi.fixedQuestionComment.domain.FixedQuestionComment;
import com.example.sonagi.fixedQuestionComment.dto.FixedQuestionCommentDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="FixedQuestion")
public class FixedQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 255)
    private String content;

    @Column
    private Long dailyNum;

    @OneToMany(mappedBy = "fixedQuestion")
    private List<FixedQuestionComment> fixedComments;
    
    @OneToMany(mappedBy = "fixedQuestion")
    private List<FixedAnswer> fixedAnswers;

    public void addFixedComments(FixedQuestionComment fixedQuestionComment){
        fixedComments.add(fixedQuestionComment);
    }

}
