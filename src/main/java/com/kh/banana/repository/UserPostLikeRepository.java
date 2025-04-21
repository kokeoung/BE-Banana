package com.kh.banana.repository;

import com.kh.banana.entity.UserPostLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPostLikeRepository extends JpaRepository<UserPostLikeEntity, Long> {
}
