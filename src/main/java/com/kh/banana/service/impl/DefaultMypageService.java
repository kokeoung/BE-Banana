package com.kh.banana.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.MypageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultMypageService implements MypageService{
	
	private final UserRepository repo;

	@Override
	public ResponseEntity<?> findUser(String userAccount) {
		Optional<UserEntity> dao = repo.findByUserAccount(userAccount);
		System.out.println("성공.");
		return ResponseEntity.ok(dao);
	}

	@Override
	public ResponseEntity<?> updateUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
