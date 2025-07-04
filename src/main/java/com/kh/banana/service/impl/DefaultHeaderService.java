package com.kh.banana.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.HeaderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultHeaderService implements HeaderService{

    private final UserRepository userRepo;

    @Override
    public ResponseEntity<?> userProfileFind(AccountCheckDTO dto) {
        UserEntity user = userRepo.findByUserId(dto.getUserId());
        String result = user.getUserProfileImage();
        return ResponseEntity.ok(result);
    }

}