package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

public interface MypageService {

	ResponseEntity<?> findUser(String userId);

	ResponseEntity<?> updateUser();

}
