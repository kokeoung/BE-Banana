package com.kh.banana.dto;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class PostDTO {
	private Long writer;
	private String postTitle;
	private String postContent;
	private int postLike;
}
