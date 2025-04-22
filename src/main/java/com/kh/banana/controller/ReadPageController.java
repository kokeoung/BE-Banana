package com.kh.banana.controller;

import com.kh.banana.dto.response.PostDetailResponseDTO;
import com.kh.banana.service.PostDetailService;
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

    @GetMapping("/read/{postId}")
    public ResponseEntity<PostDetailResponseDTO> getPostDetailPage(@PathVariable Long postId) {
        PostDetailResponseDTO post = postDetailService.getPostDetail(postId);
        return ResponseEntity.ok(post);
    }
}
