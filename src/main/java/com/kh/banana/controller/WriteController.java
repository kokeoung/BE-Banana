package com.kh.banana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.banana.dto.request.PostRequestDTO;
import com.kh.banana.dto.request.PostUpdateRequestDTO;
import com.kh.banana.service.WriteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class WriteController {

	private final WriteService service;

	@PostMapping("/api/write")
	public ResponseEntity<?> savePost(@RequestBody PostRequestDTO dto) {
		return service.savePost(dto);
	}
	@PostMapping("/api/write/url")
	public ResponseEntity<?> saveImage(
			@RequestParam(value = "postFile", required = false) MultipartFile postFile) {

		return service.saveImage(postFile);
	}
	@GetMapping("/api/write/{postid}")
	public ResponseEntity<?> getPost(@PathVariable(value = "postid")Long postId) {
		return service.getPost(postId);
	}
	@PostMapping("/api/write/update")
	public ResponseEntity<?> updatePost(@RequestBody PostUpdateRequestDTO dto) {
		System.out.println(dto.getPostId());
		return service.updatePost(dto);
	}

}