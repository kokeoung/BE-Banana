package com.kh.banana.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.kh.banana.dto.request.UpdateUserDTO;

public interface MypageService {
//

	ResponseEntity<?> findUser(String userId);

	ResponseEntity<?> updateUser(UpdateUserDTO dto, MultipartFile userProfile);

	ResponseEntity<?> findUserPost(String userId);

}
