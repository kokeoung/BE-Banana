package com.kh.banana.service;

import com.kh.banana.dto.response.PostDetailResponseDTO;
import org.springframework.http.ResponseEntity;

public interface PostDetailService {

    PostDetailResponseDTO getPostDetail(Long postId);
}
