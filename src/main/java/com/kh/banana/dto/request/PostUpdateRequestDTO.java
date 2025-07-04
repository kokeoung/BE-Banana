package com.kh.banana.dto.request;

import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostUpdateRequestDTO {

    // 게시글 작성, 수정요청 dto
    private Long user;
    private String postTitle;
    private String postContent;
    private String thumbnail;
    private Long postId;

}