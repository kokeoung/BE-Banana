package com.kh.banana.service.impl;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.dto.request.UserLoginRequestDTO;
import com.kh.banana.dto.request.UserSignupRequestDTO;
import com.kh.banana.dto.response.UserLoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

	private final UserRepository repo;
	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public ResponseEntity<?> userSave(UserSignupRequestDTO dto) {
		String encodedPassword = passwordEncoder.encode(dto.getUserPass());
		UserEntity userEntity = dto.toEntity(encodedPassword);
		repo.save(userEntity);
		return ResponseEntity.ok("회원가입 성공");
	}

	@Override
	public boolean idCheck(AccountCheckDTO dto) {
		return repo.existsByUserId(dto.getUserId());
	}

	@Override
	public ResponseEntity<?> loginCheck(UserLoginRequestDTO dto) {
		// 1. 아이디로 유저 조회
		UserEntity user = repo.findByUserId(dto.getUserId());

		// 2. 아이디 없음 → 실패
		if (user == null) {
			System.out.println("로그인 실패: 아이디 없음");
			return ResponseEntity.ok("로그인 실패");
		}

		// 3. 비밀번호 일치 여부 확인 (암호화된 비번과 비교)
		boolean isMatch = passwordEncoder.matches(dto.getUserPass(), user.getUserPass());

		if (!isMatch) {
			System.out.println("로그인 실패: 비밀번호 불일치");
			return ResponseEntity.ok("로그인 실패");
		}

		// 4. 로그인 성공
		System.out.println("로그인 성공");
		UserLoginResponseDTO result = UserLoginResponseDTO.fromEntity(user);
		return ResponseEntity.ok(result);
	}
}