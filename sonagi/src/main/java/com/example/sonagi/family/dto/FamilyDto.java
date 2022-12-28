package com.example.sonagi.family.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyDto {
    private Long id;
    private String code;
    private LocalDate createdAt;
}
