package com.kh.banana.service;

import org.springframework.http.ResponseEntity;

public interface ReadService {

    ResponseEntity<?> deletePost(Long postId);

}