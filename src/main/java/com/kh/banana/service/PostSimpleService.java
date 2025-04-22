package com.kh.banana.service;

import com.kh.banana.dto.response.PostSimpleResponseDTO;

import java.util.List;

public interface PostSimpleService {

    List<PostSimpleResponseDTO> getPostListForMainPage();
}
