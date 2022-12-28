package com.example.sonagi.fixedAnswer.dto;

import com.example.sonagi.fixedAnswer.domain.FixedAnswer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FixedAnswerByYearDto {
    private int year;
    private List<FixedAnswerDto> answers;
}
