package com.example.sonagi.user.service;

import com.example.sonagi.exception.BusinessException;
import com.example.sonagi.family.service.FamilyService;
import com.example.sonagi.jwt.JwtProvider;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import com.example.sonagi.user.dto.UserCreation;
import com.example.sonagi.user.dto.UserLogin.Request;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
	private final JwtProvider jwtProvider;
	private final PasswordEncoder passwordEncoder;
	public final FamilyService familyService;
	public final UserRepository userRepository;

	@Transactional
	public UserCreation.Response register(UserCreation.Request request) {
		Optional<User> userOpt = userRepository.findByUsername(request.getUsername());
		if (userOpt.isPresent()) {
			throw BusinessException.USERNAME_ALREADY_EXIST;
		}

		User user = User.createUser(request, passwordEncoder);
		User savedUser = userRepository.save(user);

		// 가족 생성 또는 가족 코드를 통한 멤버 추가
		String familyCode;
		if (request.getFamilyCode() != null) {
			familyService.addFamilyMember(savedUser, request.getFamilyCode());
			familyCode = request.getFamilyCode();
		} else {
			familyCode = familyService.createFamily(savedUser);
		}
		return new UserCreation.Response(familyCode);
	}

	public String login(Request loginRequest) {
		User user = userRepository.findByUsername(loginRequest.getUsername())
			.orElseThrow(() -> BusinessException.USER_NOT_FOUND_BY_USERNAME);
		validateLogin(user, loginRequest.getPassword());

		return jwtProvider.createToken(user.getUsername());
	}

	private void validateLogin(User user, String password) {
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw BusinessException.USER_NOT_FOUND_BY_PASSWORD;
		}
	}
}
