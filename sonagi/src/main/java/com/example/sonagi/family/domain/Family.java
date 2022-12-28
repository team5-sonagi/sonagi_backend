package com.example.sonagi.family.domain;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;

import com.example.sonagi.user.domain.User;
import lombok.Getter;

@Getter
@Entity
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column
	private String code;

	@Column
	private LocalDate createdAt;

}