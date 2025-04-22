package com.kh.banana.service.impl;

import com.kh.banana.dto.response.PostDetailResponseDTO;
import com.kh.banana.entity.PostEntity;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.service.PostDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDetailImplService implements PostDetailService {

    private final PostRepository postRepository;

    @Override
    public PostDetailResponseDTO getPostDetail(Long postId) {
        PostDetailResponseDTO postDetailResponseDTO = new PostDetailResponseDTO();

        PostEntity postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return postDetailResponseDTO.fromEntity(postEntity);
    }
}
