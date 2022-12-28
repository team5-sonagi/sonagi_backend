package com.example.sonagi.family.controller;

import com.example.sonagi.family.dto.FamilyDto;
import com.example.sonagi.family.service.FamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class FamilyController {

    private final FamilyService familyService;

    @GetMapping(value="/family")
    public int famInfo(@RequestParam Long id){
        int dDay = familyService.getDDay(id);
        return dDay;
    }

}
