package com.kh.banana.dto.response;

import com.kh.banana.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDetailResponseDTO {

    private Long postId;
    private String postTitle;
    private String postContent;
    private String thumbnail;

    private int likeCount;
    private boolean likedByCurrentUser;

    // 작성자 정보
    private Long userId;
    private String userNick;
    private String userProfileImage;

    // 댓글 리스트
    private List<CommentResponseDTO> comments;

    public static PostDetailResponseDTO fromEntity(PostEntity entity) {
        // 댓글 리스트 변환
        List<CommentResponseDTO> commentDTOs = entity.getComment().stream()
                .map(CommentResponseDTO::fromEntity) // CommentEntity -> CommentResponseDTO 변환
                .collect(Collectors.toList());

        // PostEntity -> PostDetailResponseDTO 변환
        return new PostDetailResponseDTO(
                entity.getId(),
                entity.getPostTitle(),
                entity.getPostContent(),
                entity.getThumbnail(),
                0, // 좋아요 수, 이건 추후 로직에서 처리 (예: likeCount 메서드)
                false, // 현재 사용자가 좋아요 눌렀는지 여부 (추후 구현 필요)
                entity.getUser().getId(), // 작성자 ID
                entity.getUser().getUserNick(), // 작성자 닉네임
                entity.getUser().getUserProfileImage(), // 작성자 프로필 이미지
                commentDTOs // 댓글 리스트
        );
    }
}