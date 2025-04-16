package com.kh.banana.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.dto.IdCheckDTO;
import com.kh.banana.dto.LoginCheckDTO;
import com.kh.banana.dto.UserDTO;
import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

	private final UserRepository repo;
	
	@Override
	public ResponseEntity<?> save(UserDTO dto) {
		UserEntity dao = UserEntity.from(dto);
		System.out.println(dao);
		repo.save(dao);
		return ResponseEntity.ok("성공");
	}

	@Override
	public boolean idCheck(IdCheckDTO dto) {
		return repo.existsByUserId(dto.getUserId());
	}
	
	@Override
	public ResponseEntity<?> loginCheck(LoginCheckDTO dto) {
		boolean check = repo.existsByUserIdAndUserPass(dto.getUserId(),dto.getUserPass());
		System.out.println("로그인 아이디"+dto.getUserId());
		System.out.println("로그인 아이디"+dto.getUserPass());
		if(!check) { 
			System.out.println("로그인 실패");
			return ResponseEntity.ok("로그인 실패");
		}
		Optional<UserEntity> dao = repo.findByUserId(dto.getUserId());
		System.out.println("로그인 성공");
		return ResponseEntity.ok(dao);
	}
}
