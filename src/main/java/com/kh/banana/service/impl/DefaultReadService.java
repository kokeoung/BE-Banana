package com.kh.banana.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kh.banana.entity.PostEntity;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.service.ReadService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultReadService implements ReadService{

    private final PostRepository postRepo;

    @Override
    public ResponseEntity<?> deletePost(Long postId) {

        PostEntity post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        postRepo.delete(post);
        return ResponseEntity.ok("성공!");
    }

}