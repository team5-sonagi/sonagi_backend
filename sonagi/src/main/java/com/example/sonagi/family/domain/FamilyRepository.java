package com.example.sonagi.family.domain;

import com.example.sonagi.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {
	Optional<Family> findByCode(String code);
	Optional<Family> findByMembers(User user);
}
