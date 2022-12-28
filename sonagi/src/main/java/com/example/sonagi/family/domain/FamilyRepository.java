package com.example.sonagi.family.domain;

import com.example.sonagi.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Long> {
	Optional<Family> findByCode(String code);
	Optional<Family> findByMembers(User user);
}
