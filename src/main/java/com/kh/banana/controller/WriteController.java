package com.kh.banana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.banana.dto.request.PostRequestDTO;
import com.kh.banana.dto.request.UpdateUserDTO;
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
}
