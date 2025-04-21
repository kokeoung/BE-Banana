package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

public interface MypageService {

	ResponseEntity<?> findUser(String userAccount);

	ResponseEntity<?> updateUser();

}
