package com.kh.banana.dto.response;

import com.kh.banana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserFollowResponseDTO {

    // 팔로우, 팔로잉 목록 userProfileDTO 에서 List 형태로 조회
    private Long userId; // 팔로워 혹은 팔로잉 유저 ID
    private String userNick; // 유저닉네임
    private String profileImage; // 유저프로필이미지

    public static UserFollowResponseDTO fromEntity(UserEntity entity) {
        return new UserFollowResponseDTO(
                entity.getId(),
                entity.getUserNick(),
                entity.getUserProfileImage()
        );
    }
}
