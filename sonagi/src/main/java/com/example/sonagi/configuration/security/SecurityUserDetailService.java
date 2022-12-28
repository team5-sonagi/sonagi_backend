package com.example.sonagi.configuration.security;

import com.example.sonagi.exception.BusinessException;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityUserDetailService implements UserDetailsService {
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
			.orElseThrow(() -> BusinessException.USER_NOT_FOUND_BY_USERNAME);

		return org.springframework.security.core.userdetails.User.builder()
			.username(username)
			.password(user.getPassword())
			.roles("")
			.build();
	}
}
