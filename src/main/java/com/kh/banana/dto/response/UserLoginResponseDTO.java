package com.kh.banana.dto.response;

import com.kh.banana.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginResponseDTO {

	private Long id;
	private String userId;
	private String userProfile;
	private String userNick;
	private String userAbout;

	public static UserLoginResponseDTO fromEntity(UserEntity entity) {
		return new UserLoginResponseDTO(
				entity.getId(),
				entity.getUserId(),
				entity.getUserProfileImage(),
				entity.getUserNick(),
				entity.getUserAbout()
		);
	}

}