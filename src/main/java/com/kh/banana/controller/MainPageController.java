package com.kh.banana.controller;

import com.kh.banana.dto.response.PostSimpleResponseDTO;
import com.kh.banana.service.PostSimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainPageController {

    private final PostSimpleService postSimpleService;

    // 메인페이지에 보여줄 게시글 목록을 반환하는 API
    @GetMapping("/home")
    public List<PostSimpleResponseDTO> getMainPagePosts() {
        // 게시글 목록을 가져와서 DTO로 변환해서 반환
        return postSimpleService.getPostListForMainPage();
    }
}
