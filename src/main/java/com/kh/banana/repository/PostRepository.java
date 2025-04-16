package com.kh.banana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.banana.entity.PostEntity;


public interface PostRepository extends JpaRepository<PostEntity, Long>{
	
}
