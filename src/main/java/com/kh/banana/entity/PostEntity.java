package com.kh.banana.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="post")
@Entity
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "writer_id",nullable = false) // Post 테이블에 생기는 FK 컬럼
	private UserEntity writerId;
	@Column(nullable = false)
	private String postTitle;
	@Column(nullable = false)
	private String postContent;
	@Column(nullable = false)
	private int postLike;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createAt;
}
