package com.kh.banana.service;

import java.util.List;

import com.kh.banana.dto.response.PostSimpleResponseDTO;

public interface SearchService {
	List<PostSimpleResponseDTO> getAllPosts();

	List<PostSimpleResponseDTO> searchPosts(String keyword);

}