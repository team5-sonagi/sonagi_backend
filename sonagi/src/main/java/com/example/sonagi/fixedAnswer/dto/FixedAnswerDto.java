package com.example.sonagi.fixedAnswer.dto;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
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
public class FixedAnswerDto {
    private Long id;
    private String name;
    private Long userId;
    private Long familyId;
    private String content;
    private LocalDateTime createdAt;

    public static FixedAnswerDto from (FixedAnswer answer){
        return FixedAnswerDto.builder()
                .id(answer.getId())
                .name(answer.getWriter().getName())
                .userId(answer.getWriter().getId())
                .familyId(answer.getFamilyId())
                .content(answer.getContent())
                .createdAt(answer.getCreatedAt())
                .build();
    }

    public static List<FixedAnswerDto> from(List<FixedAnswer> answers){
        List<FixedAnswerDto> list = new ArrayList<>();
        for(FixedAnswer answer : answers){
            list.add(FixedAnswerDto.from(answer));
        }
        return list;
    }
}
