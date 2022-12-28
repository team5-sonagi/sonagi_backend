package com.example.sonagi.family.service;

import com.example.sonagi.exception.BusinessException;
import com.example.sonagi.family.domain.Family;
import com.example.sonagi.family.domain.FamilyRepository;
import com.example.sonagi.user.domain.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FamilyService {
	private final FamilyRepository familyRepository;

	@Transactional
	public String createFamily(User user) {
		List<User> members = new ArrayList<>();
		members.add(user);

		Family family = Family.builder()
			.code(UUID.randomUUID().toString())
			.members(members)
			.createdAt(LocalDate.now())
			.build();
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

}
