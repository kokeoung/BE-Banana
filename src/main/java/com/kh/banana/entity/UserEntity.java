package com.kh.banana.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

	@Column(nullable = false,unique = true)
	private String userAccount;

	@Column(nullable = false)
	private String userPass;

	@Column(nullable = false)
	private String userNick;

	private String userProfileImage;
	private String userAbout;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PostEntity> postList = new ArrayList<>();

	@OneToMany(mappedBy = "follower")
	private List<FollowEntity> follower = new ArrayList<>();

	@OneToMany(mappedBy = "followed")
	private List<FollowEntity> followed = new ArrayList<>();


	public static UserEntity createUserForLogin(String userAccount, String userPass) {
		UserEntity userEntity = new UserEntity();
		userEntity.userAccount = userAccount;
		userEntity.userPass = userPass;
		return userEntity;
	}

	public static UserEntity createUserForSignup(String userAccount, String userPass, String userNick) {
		UserEntity userEntity = new UserEntity();
		userEntity.userAccount = userAccount;
		userEntity.userPass = userPass;
		userEntity.userNick = userNick;
		return userEntity;
	}
}
