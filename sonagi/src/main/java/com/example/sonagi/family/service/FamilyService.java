package com.example.sonagi.family.service;

import com.example.sonagi.family.domain.Family;
import com.example.sonagi.family.domain.FamilyRepository;
import com.example.sonagi.family.dto.FamilyDto;
import jdk.jfr.Period;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

    public FamilyDto findById(Long id){
        Optional<Family> optionalFamily = familyRepository.findById(id);
        if(optionalFamily.isEmpty()){
            throw new RuntimeException();
        }else {
            Family fam = optionalFamily.get();
            return new FamilyDto(fam.getId(), fam.getCode(), fam.getCreatedAt());
        }
    }
    public int getDDay(Long id){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = this.findById(id).getCreatedAt();
        LocalDate end = LocalDate.now();
        int dDay = (int) Duration.between(end.atStartOfDay(), start.atStartOfDay()).toDays();
        return Math.abs(dDay) % 365;
    }
}
