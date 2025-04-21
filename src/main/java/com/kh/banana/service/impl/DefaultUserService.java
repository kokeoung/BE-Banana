package com.kh.banana.service.impl;

import java.util.Optional;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.dto.request.UserLoginRequestDTO;
import com.kh.banana.dto.request.UserSignupRequestDTO;
import com.kh.banana.dto.response.UserProfileResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

	private final UserRepository repo;

	@Override
	public ResponseEntity<?> userSave(UserSignupRequestDTO dto) {
		UserEntity userEntity = dto.toEntity();
		repo.save(userEntity);
		return ResponseEntity.ok("회원가입 성공");
	}

	@Override
	public boolean idCheck(AccountCheckDTO dto) {
		return repo.existsByUserAccount(dto.getUserAccount());
	}
	
	@Override
	public ResponseEntity<?> loginCheck(UserLoginRequestDTO dto) {
		boolean check = repo.existsByUserAccountAndUserPass(dto.getUserAccount(),dto.getUserPass());
		System.out.println("로그인 아이디"+dto.getUserAccount());
		System.out.println("로그인 아이디"+dto.getUserPass());
		if(!check) { 
			System.out.println("로그인 실패");
			return ResponseEntity.ok("로그인 실패");
		}
		Optional<UserEntity> dao = repo.findByUserAccount(dto.getUserAccount());
		System.out.println("로그인 성공");
		return ResponseEntity.ok(dao);
	}
}
