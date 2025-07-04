package com.kh.banana.controller;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.dto.request.UserLoginRequestDTO;
import com.kh.banana.dto.request.UserSignupRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.banana.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Slf4j
public class AuthController {

	private final UserService service;

	@PostMapping("/api/auth")
	public ResponseEntity<?> userSave(@RequestBody UserSignupRequestDTO dto) {//Jackson
		return service.	userSave(dto);
	}
	@PostMapping("/api/check-id")
	public ResponseEntity<?> idCheck(@RequestBody AccountCheckDTO dto) {
		return ResponseEntity.ok(service.idCheck(dto));
	}
	@PostMapping("/api/login")
	public ResponseEntity<?> loginCheck(@RequestBody UserLoginRequestDTO dto) {
		System.out.println("요청확인");
		return ResponseEntity.ok(service.loginCheck(dto));
	}
}
   