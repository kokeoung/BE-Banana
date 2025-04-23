package com.kh.banana.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultSearchService implements SearchService{
	
	private final PostRepository postRepository;

	@Override
	public List<PostSimpleResponseDTO> getAllPosts() {
		return postRepository.findAll().stream()
				.map(PostSimpleResponseDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	
}
