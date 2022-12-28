package com.example.sonagi.family.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import com.example.sonagi.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column
	private String code;
	private LocalDate createdAt;

	@OneToMany(mappedBy = "family")
	private List<User> members;

	public static Family createMember(User user) {
		List<User> members = new ArrayList<>();
		members.add(user);

		Family family = Family.builder()
			.code(UUID.randomUUID().toString())
			.members(members)
			.createdAt(LocalDate.now())
			.build();
		user.setFamily(family);

		return family;
	}

	public void addMember(User user) {
		members.add(user);
		user.setFamily(this);
	}
}
