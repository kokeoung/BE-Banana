package com.kh.banana.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.banana.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	boolean existsByUserAccount(String userAccount);

	boolean existsByUserAccountAndUserPass(String userAccount,String userPass);

	Optional<UserEntity> findByUserAccount(String userAccount);
	
}
