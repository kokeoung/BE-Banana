package com.kh.banana.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.banana.dto.request.UpdateUserDTO;
import com.kh.banana.service.MypageService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
public class MyController {
	
	private final MypageService service;
	
	@PostMapping("/api/my/{userId}")
	public ResponseEntity<?> findUser(@PathVariable(value = "userId")String userId) {
		return service.findUser(userId);
	}
	
	@PostMapping("/api/my/change")
	public ResponseEntity<?> updateUser(
			@ModelAttribute UpdateUserDTO dto,
			@RequestParam("userProfile") MultipartFile userProfile) {
		return service.updateUser(dto,userProfile);
	}
	
	@PostMapping("/api/my/post/{userId}")
	public ResponseEntity<?> findUserPost(@PathVariable(value = "userId")String userId) {
		return service.findUserPost(userId);
	}
}
