package com.kh.banana.service.impl;

import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.entity.PostEntity;
import com.kh.banana.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostSimpleService implements com.kh.banana.service.PostSimpleService {

    private final PostRepository postRepository;

    @Override
    public List<PostSimpleResponseDTO> getPostListForMainPage() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream()
                .map(PostSimpleResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
