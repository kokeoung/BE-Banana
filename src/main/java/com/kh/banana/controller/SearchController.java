package com.kh.banana.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController //return 값이 자동으로 json으로 반환
@RequestMapping("/api/search") //url 경로 설정
@RequiredArgsConstructor //final 필드 생성자 자동 생성
public class SearchController {
	
	private final SearchService searchService;
	
	//우선, 검색어 없이 전체 데이터 반환
	@PostMapping
	public List<PostSimpleResponseDTO> getAllPostsForSearchPage(){
		return searchService.getAllPosts();
		
	}
	
}
