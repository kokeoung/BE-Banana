package com.kh.banana.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="user")
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_id", nullable = false, unique = true)
	private String userId;

	@Column(name="user_pass", nullable = false)
	private String userPass;

	@Column(name="user_nick", nullable = false)
	private String userNick;

	private String userProfileImage;
	private String userAbout;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PostEntity> postList = new ArrayList<>();

	public static UserEntity createUserForLogin(String userId, String userPass) {
		UserEntity userEntity = new UserEntity();
		userEntity.userId = userId;
		userEntity.userPass = userPass;
		return userEntity;
	}

	public static UserEntity createUserForSignup(String userId, String userPass, String userNick) {
		UserEntity userEntity = new UserEntity();
		userEntity.userId = userId;
		userEntity.userPass = userPass;
		userEntity.userNick = userNick;
		return userEntity;
	}

	public UserEntity(String userId, String userPass, String userNick, String userProfileImage) {
		this.userId = userId;
		this.userPass = userPass;
		this.userNick = userNick;
		this.userProfileImage = userProfileImage;
	}
	public void updateUserNickInfo(String userNick) {
		this.userNick = userNick;
	}
	public void updateUserAboutInfo(String userAbout) {
		this.userAbout = userAbout;
	}

	public void updateUserProfileo(String imageUrl) {
		this.userProfileImage = imageUrl;
	}
}