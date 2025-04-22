package com.kh.banana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.banana.entity.PostEntity;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<PostEntity, Long>{
    List<PostEntity> findAll();

    Optional<PostEntity> findById(Long id);
}
