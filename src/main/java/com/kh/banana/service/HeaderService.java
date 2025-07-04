package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

import com.kh.banana.dto.request.AccountCheckDTO;

public interface HeaderService {

    ResponseEntity<?> userProfileFind(AccountCheckDTO dto);

}