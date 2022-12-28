package com.example.sonagi.family.service;

import com.example.sonagi.exception.BusinessException;
import com.example.sonagi.family.domain.Family;
import com.example.sonagi.family.domain.FamilyRepository;
import com.example.sonagi.family.dto.FamilyDto;
import com.example.sonagi.user.domain.User;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FamilyService {

    private final FamilyRepository familyRepository;

	@Transactional
	public String createFamily(User user) {
		Family family = Family.createMember(user);
		Family savedFamily = familyRepository.save(family);
		return savedFamily.getCode();
	}

	@Transactional
	public void addFamilyMember(User user, String familyCode) {
		Family family = familyRepository.findByCode(familyCode)
			.orElseThrow(() -> BusinessException.NOT_FOUND_FAMILY_CODE);
		family.addMember(user);
		familyRepository.save(family);
	}

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
        LocalDate start = this.findById(id).getCreatedAt();
        LocalDate end = LocalDate.now();
        int dDay = (int) Duration.between(end.atStartOfDay(), start.atStartOfDay()).toDays();
        return Math.abs(dDay) % 365;
    }
}
