package com.kh.banana.dto.response;

import com.kh.banana.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostSimpleResponseDTO {

    // 포스트카드에 노출되는 게시글 정보
    private Long postId;
    private String postTitle;
    private String postContent;
    private String thumbnail;
    private String userProfileImage;
    private String userNick;
    private int likeCount;
    private Long comments;
    private LocalDateTime createDateTime;
    private Long id;
    private String userId;



    public static PostSimpleResponseDTO fromEntity(PostEntity entity) {
        return new PostSimpleResponseDTO(
                entity.getId(),
                entity.getPostTitle(),
                entity.getPostContent(),
                entity.getThumbnail(),
                entity.getUser().getUserProfileImage(), // 작성자 프로필 이미지
                entity.getUser().getUserNick(), // 작성자 닉네임
                0, // 좋아요 수 (이건 추후 로직에서 처리)
                (long) entity.getComment().size(), //댓글 수 카운트
                entity.getCreateDateTime(),
                entity.getUser().getId(), // 작성자 ID
                entity.getUser().getUserId()
        );
    }
}

