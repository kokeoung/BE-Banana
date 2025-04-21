package com.kh.banana.dto.response;

import com.kh.banana.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostSimpleResponseDTO {

    // 포스트카드에 노출되는 게시글 정보
    private Long postId;
    private String postTitle;
    private String postContent;
    private String thumbnail;

    private int likeCount;

    private Long userId;
    private String userNick;
    private String userProfileImage;

    public static PostSimpleResponseDTO fromEntity(PostEntity entity) {
        return new PostSimpleResponseDTO(
                entity.getId(),
                entity.getPostTitle(),
                entity.getPostContent(),
                entity.getThumbnail(),
                0, // 좋아요 수 (이건 추후 로직에서 처리)
                entity.getUser().getId(), // 작성자 ID
                entity.getUser().getUserNick(), // 작성자 닉네임
                entity.getUser().getUserProfileImage() // 작성자 프로필 이미지
        );
    }
}


