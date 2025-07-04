package com.kh.banana.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.banana.dto.request.SearchKeywordRequestDTO;
import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.service.SearchService;

import lombok.RequiredArgsConstructor;

@RestController //return 값이 자동으로 json으로 반환
@RequestMapping("/api/search") //url 경로 설정
@RequiredArgsConstructor //final 필드 생성자 자동 생성
public class SearchController {

	private final SearchService searchService;

	//기본 경로
	@PostMapping
	public List<PostSimpleResponseDTO> getAllPosts(){
		return searchService.getAllPosts();
	}
	//키워드 검색
	//@RequestBody json -> java 객체로 변환
	@PostMapping("/keyword")
	public List<PostSimpleResponseDTO> searchByKeyword(@RequestBody SearchKeywordRequestDTO request){
		return searchService.searchPosts(request.getKeyword());
	}

}