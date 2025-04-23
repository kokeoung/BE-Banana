package com.kh.banana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<PostEntity, Long>{

	List<PostEntity> findByUser(UserEntity entity);
	
}
