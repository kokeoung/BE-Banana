package com.kh.banana.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.kh.banana.dto.PostDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="post")
@Entity
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writer_id",nullable = false) // Post 테이블에 생기는 FK 컬럼
	private UserEntity writer; // writerId로 필드명 만들면 gpt가 계속 writer로 만들라고 뭐라함.
	@Column(nullable = false)
	private String postTitle;
	@Column(nullable = false)
	private String postContent;
	@Column(nullable = false)
	private int postLike;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createAt;
	
	public static PostEntity from(PostDTO dto) {
		PostEntity dao = new PostEntity();
		UserEntity writer = new UserEntity();
	    writer.setId(dto.getWriter());
	    
		dao.writer = writer; // 객체 이름만 적으면 default로 getId임.
		dao.postTitle = dto.getPostTitle();
		dao.postContent = dto.getPostContent();
		dao.postLike = dto.getPostLike();
		return dao;
	}
}
