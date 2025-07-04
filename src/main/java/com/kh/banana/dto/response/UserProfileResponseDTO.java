package com.kh.banana.dto.response;

import com.kh.banana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserProfileResponseDTO {

    private String userProfileImage; // 유저프로필이미지
    private String userNick; // 유저닉네임
    private String userAbout; // 유저설명

    private List<PostSimpleResponseDTO> posts; // 게시글 미리보기 목록

    public static UserProfileResponseDTO fromEntity(UserEntity entity, int followerCount, int followingCount, List<PostSimpleResponseDTO> posts) {
        return new UserProfileResponseDTO(
                entity.getUserProfileImage(),
                entity.getUserNick(),
                entity.getUserAbout(),
                posts
        );
    }
}