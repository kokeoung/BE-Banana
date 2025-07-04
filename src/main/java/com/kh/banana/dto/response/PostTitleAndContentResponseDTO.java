package com.kh.banana.dto.response;

import java.time.LocalDateTime;

import com.kh.banana.entity.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostTitleAndContentResponseDTO {
    private String postTitle;
    private String postContent;

    public static PostTitleAndContentResponseDTO fromEntity(PostEntity entity) {
        return new PostTitleAndContentResponseDTO(
                entity.getPostTitle(),
                entity.getPostContent()
        );
    }
}