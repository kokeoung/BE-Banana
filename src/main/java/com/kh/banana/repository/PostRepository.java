package com.kh.banana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;

import jakarta.persistence.Column;

import java.util.List;
import java.util.Optional;



public interface PostRepository extends JpaRepository<PostEntity, Long>{

	List<PostEntity> findByUserOrderByIdDesc(UserEntity entity);

	//PostEntity, postContent에 입력된 키워드 기준으로 대소문자 상관없이 검색
	//@Column(columnDefinition = "LONGTEXT",nullable = false)
	//private String postContent;
	//Hibernate CLOB 타입 강제 String으로 캐스팅
	@Query
			("SELECT p FROM PostEntity p WHERE LOWER(CAST(p.postTitle AS string)) "
					+ "LIKE LOWER(CONCAT('%', :keyword, '%')) "
					+ "OR LOWER(CAST(p.postContent AS string)) "
					+ "LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<PostEntity> searchByKeyword(@Param("keyword") String Keyword);

}