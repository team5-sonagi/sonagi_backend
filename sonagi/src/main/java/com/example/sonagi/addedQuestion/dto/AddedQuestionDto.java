package com.example.sonagi.addedQuestion.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class AddedQuestionDto {
    @NotBlank(message = "content cannot be blank")
    private String content;
}
