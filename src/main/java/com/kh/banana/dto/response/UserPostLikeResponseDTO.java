package com.kh.banana.dto.response;

import com.kh.banana.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPostLikeResponseDTO {

    private Long postId; // 게시글 id
    private int likeCount; // 좋아요 수

    // 정적 팩토리 메서드
    public static UserPostLikeResponseDTO fromEntity(PostEntity entity) {
        return new UserPostLikeResponseDTO(
                entity.getId(),
                0 // 좋아요 수 (추후 로직에서 처리)
        );
    }
}
