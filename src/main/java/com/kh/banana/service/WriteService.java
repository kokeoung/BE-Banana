package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

import com.kh.banana.dto.request.PostRequestDTO;

public interface WriteService {

	ResponseEntity<?> savePost(PostRequestDTO dto);

}
