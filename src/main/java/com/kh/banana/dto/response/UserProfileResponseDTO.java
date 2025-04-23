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

    // 유저프로필조회
    private String userProfileImage; // 유저프로필이미지
    private String userNick; // 유저닉네임
    private String userAbout; // 유저설명

    // 팔로워,팔로잉 수
    private int follower;
    private int following;
    // 팔로워, 팔로잉 목록
    private List<UserFollowResponseDTO> followerList;
    private List<UserFollowResponseDTO> followingList;

    private List<PostSimpleResponseDTO> posts; // 게시글 미리보기 목록

    public static UserProfileResponseDTO fromEntity(UserEntity entity) {
        // 팔로워/팔로잉 수 계산
        int followerCount = entity.getFollower().size();
        int followingCount = entity.getFollowed().size();

        // 팔로워, 팔로잉 목록 변환
        List<UserFollowResponseDTO> followerList = entity.getFollower().stream()
                .map(follow -> UserFollowResponseDTO.fromEntity(follow.getFollower()))
                .collect(Collectors.toList());

        List<UserFollowResponseDTO> followingList = entity.getFollowed().stream()
                .map(follow -> UserFollowResponseDTO.fromEntity(follow.getFollowed()))
                .collect(Collectors.toList());

        // 게시글 목록 변환
        List<PostSimpleResponseDTO> postList = entity.getPostList().stream()
                .map(PostSimpleResponseDTO::fromEntity)
                .collect(Collectors.toList());

        return new UserProfileResponseDTO(
                entity.getUserProfileImage(),
                entity.getUserNick(),
                entity.getUserAbout(),
                followerCount,
                followingCount,
                followerList,
                followingList,
                postList
        );
    }
}
