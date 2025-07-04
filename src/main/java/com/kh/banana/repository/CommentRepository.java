package com.kh.banana.repository;

import com.kh.banana.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByPostId(Long postId);

    Optional<CommentEntity> findById(Long commentId);
}