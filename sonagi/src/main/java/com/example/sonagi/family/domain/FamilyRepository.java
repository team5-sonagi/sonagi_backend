package com.example.sonagi.family.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}
