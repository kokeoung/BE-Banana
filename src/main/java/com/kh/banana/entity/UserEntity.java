package com.kh.banana.entity;

import com.kh.banana.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="user")
@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,unique = true)
	private String userId;
	@Column(nullable = false)
	private String userPass;
	@Column(nullable = false)
	private String userNick;
	private String userProfile;
	private String userAbout;
	
	public static UserEntity from(UserDTO dto) {
		UserEntity dao = new UserEntity();
		dao.userId = dto.getUserId();
		dao.userPass = dto.getUserPass();
		dao.userNick = dto.getUserNick();
		dao.userProfile = dto.getUserProfile();
		dao.userAbout = dto.getUserAbout();
		return dao;
	}
}
