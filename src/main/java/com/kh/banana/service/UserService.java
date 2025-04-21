package com.kh.banana.service;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.dto.request.UserLoginRequestDTO;
import com.kh.banana.dto.request.UserSignupRequestDTO;
import com.kh.banana.dto.response.UserProfileResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

	ResponseEntity<?> userSave(UserSignupRequestDTO dto);

	boolean idCheck(AccountCheckDTO dto);

	ResponseEntity<?> loginCheck(UserLoginRequestDTO dto);

}
