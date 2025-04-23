package com.kh.banana.dto.request;

import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostRequestDTO {

    // 게시글 작성, 수정요청 dto
	private Long user;
    private String postTitle;
    private String postContent;
    private String thumbnail;

    public PostEntity toEntity(UserEntity user) {
        return PostEntity.createPostEntity(this.postTitle, this.postContent, this.thumbnail, user);
    }
}
