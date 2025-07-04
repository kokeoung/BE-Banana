package com.kh.banana.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.kh.banana.dto.response.UserProfileResponseDTO;
import org.springframework.beans.factory.annotation.Value;
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
import com.kh.banana.util.S3ServiceUtil;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;

@Service
@RequiredArgsConstructor
public class DefaultMypageService implements MypageService{

	private final UserRepository userRepo;
	private final PostRepository postRepo;
	private final S3ServiceUtil s3ServiceUtil;

	@Override
	public ResponseEntity<?> findUser(String userId) {
		UserLoginResponseDTO result = UserLoginResponseDTO.fromEntity(userRepo.findByUserId(userId));
		System.out.println("성공.");
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<?> updateUser(UpdateUserDTO dto, MultipartFile userProfile) {
		System.out.println(dto.getUserId());
		UserEntity user = userRepo.findByUserId(dto.getUserId());
		if (user == null) {
			return ResponseEntity.ok("유저를 찾을 수 없습니다.");
		}
		if (dto.getUserNick() != null) {
			System.out.println(dto.getUserNick());
			user.updateUserNickInfo(dto.getUserNick());
		}
		if (dto.getUserAbout() != null) {
			System.out.println(dto.getUserAbout());
			user.updateUserAboutInfo(dto.getUserAbout());
		}
		if (userProfile != null && !userProfile.isEmpty()) {
			try {
				String imageUrl = s3ServiceUtil.uploadFile(userProfile);
				user.updateUserProfileo(imageUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userRepo.save(user);
		System.out.println("수정완료");
		return ResponseEntity.ok("성공!");
	}

	@Override
	public ResponseEntity<?> findUserPost(String userId) {
		UserEntity entity = userRepo.findByUserId(userId);
		List<PostEntity> posts = postRepo.findByUserOrderByIdDesc(entity);
		List<PostSimpleResponseDTO> result = posts.stream().map(PostSimpleResponseDTO::fromEntity).collect(Collectors.toList());
		return ResponseEntity.ok(result);
	}
}