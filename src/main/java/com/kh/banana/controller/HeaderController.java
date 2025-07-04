package com.kh.banana.controller;

import org.springframework.web.bind.annotation.RestController;

import com.kh.banana.dto.request.AccountCheckDTO;
import com.kh.banana.service.HeaderService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class HeaderController {

    private final HeaderService service;
    @PostMapping("/api/header")
    public ResponseEntity<?> userProfileFind(@RequestBody AccountCheckDTO dto) {
        return service.userProfileFind(dto);
    }

}