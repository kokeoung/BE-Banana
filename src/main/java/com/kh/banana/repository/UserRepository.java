package com.kh.banana.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.banana.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	boolean existsByUserId(String userId);

	boolean existsByUserIdAndUserPass(String userId,String userPass);

	UserEntity findByUserId(String userId);

}
