package com.kh.banana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.banana.dto.IdCheckDTO;
import com.kh.banana.dto.LoginCheckDTO;
import com.kh.banana.dto.UserDTO;
import com.kh.banana.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class AuthController {
	
	private final UserService service;
	
	@PostMapping("/api/auth")
	public ResponseEntity<?> userSave(@RequestBody UserDTO dto) {//Jackson	 
		return service.userSave(dto);
	}
	@PostMapping("/api/check-id")
	public ResponseEntity<?> idCheck(@RequestBody IdCheckDTO dto) { 
		return ResponseEntity.ok(service.idCheck(dto));
	}
	@PostMapping("/api/login")
	public ResponseEntity<?> loginCheck(@RequestBody LoginCheckDTO dto) { 
		return ResponseEntity.ok(service.loginCheck(dto));
	}
}
   