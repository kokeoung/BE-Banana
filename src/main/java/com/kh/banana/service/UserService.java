package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

import com.kh.banana.dto.IdCheckDTO;
import com.kh.banana.dto.LoginCheckDTO;
import com.kh.banana.dto.UserDTO;

public interface UserService {

	ResponseEntity<?> userSave(UserDTO dto);

	boolean idCheck(IdCheckDTO dto);

	ResponseEntity<?> loginCheck(LoginCheckDTO dto);
	
}
