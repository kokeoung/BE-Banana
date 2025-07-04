package com.kh.banana.service;

import com.kh.banana.dto.request.CommentRequestDTO;
import com.kh.banana.dto.response.CommentResponseDTO;
import com.kh.banana.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentEntity saveComment(CommentRequestDTO requestDTO, Long postId, Long userId);

    List<CommentResponseDTO> getCommentsByPostId(Long postId);

    void deleteComments(Long commentId);
}