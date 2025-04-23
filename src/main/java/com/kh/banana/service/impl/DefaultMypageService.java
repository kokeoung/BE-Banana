package com.kh.banana.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.banana.dto.request.UpdateUserDTO;
import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.dto.response.UserLoginResponseDTO;
import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.MypageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultMypageService implements MypageService{
	
	private final UserRepository userRepo;
	private final PostRepository postRepo;

	@Override
	public ResponseEntity<?> findUser(String userId) {
		UserLoginResponseDTO result = UserLoginResponseDTO.fromEntity(userRepo.findByUserId(userId));
		System.out.println("성공.");
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<?> updateUser(UpdateUserDTO dto, MultipartFile userProfile) {
		System.out.println(dto);
		System.out.println(userProfile);
		return null;
	}

	@Override
	public ResponseEntity<?> findUserPost(String userId) {
		UserEntity entity = userRepo.findByUserId(userId);
		 List<PostEntity> posts = postRepo.findByUser(entity);
		 List<PostSimpleResponseDTO> result = posts.stream().map(PostSimpleResponseDTO::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(result);
	}
	
}
