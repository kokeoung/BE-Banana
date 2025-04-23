package com.kh.banana.service.impl;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.dto.request.PostRequestDTO;
import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.WriteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultWriteService implements WriteService {
	
	private final UserRepository userRepo;
	private final PostRepository postRepo;
	
	@Override
	public ResponseEntity<?> savePost(PostRequestDTO dto) {
		UserEntity entity = userRepo.findById(dto.getUser()).get();
		postRepo.save(dto.toEntity(entity));
		return ResponseEntity.ok("성공!");
	}

}
