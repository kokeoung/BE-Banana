package com.kh.banana.entity;

import java.util.ArrayList;
import java.util.List;

import com.kh.banana.dto.request.PostUpdateRequestDTO;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name="post")
@Entity
public class PostEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String thumbnail;

	@Column(nullable = false)
	private String postTitle;

	@Lob
	@Column(columnDefinition = "LONGTEXT",nullable = false)
	private String postContent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false) // Post 테이블에 생기는 FK 컬럼
	private UserEntity user; // writerId로 필드명 만들면 gpt가 계속 writer로 만들라고 뭐라함.

	@OneToMany(mappedBy="post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CommentEntity> comment = new ArrayList<>();

	public static PostEntity createPostEntity(String postTitle, String postContent, String thumbnail, UserEntity user) {
		PostEntity postEntity = new PostEntity();
		postEntity.postTitle = postTitle;
		postEntity.postContent = postContent;
		postEntity.thumbnail = thumbnail;
		postEntity.user = user;
		return postEntity;
	}
	public void updatePostData(PostUpdateRequestDTO dto) {
		this.postTitle = dto.getPostTitle();
		this.postContent = dto.getPostContent();
		this.thumbnail = dto.getThumbnail();
	}
}