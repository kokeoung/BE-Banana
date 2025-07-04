package com.kh.banana.controller;

import com.kh.banana.dto.response.PostDetailResponseDTO;
import com.kh.banana.service.PostDetailService;
import com.kh.banana.service.ReadService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReadPageController {

    private final PostDetailService postDetailService;
    private final ReadService service;

    @GetMapping("/read/{postId}")
    public ResponseEntity<PostDetailResponseDTO> getPostDetailPage(@PathVariable(value = "postId") Long postId) {
        PostDetailResponseDTO post = postDetailService.getPostDetail(postId);
        return ResponseEntity.ok(post);
    }
    @GetMapping("/read/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "postId") Long postId){
        return service.deletePost(postId);
    }

}