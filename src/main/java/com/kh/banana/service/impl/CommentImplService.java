package com.kh.banana.service.impl;

import com.kh.banana.dto.request.CommentRequestDTO;
import com.kh.banana.dto.response.CommentResponseDTO;
import com.kh.banana.entity.CommentEntity;
import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;
import com.kh.banana.repository.CommentRepository;
import com.kh.banana.repository.PostRepository;
import com.kh.banana.repository.UserRepository;
import com.kh.banana.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentImplService implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 댓글 저장
    @Override
    public CommentEntity  saveComment(CommentRequestDTO requestDTO, Long postId, Long userId) {

        // 게시글 유무 확인
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        // 로그인 유저정보 가져오기
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.getUserProfileImage();

        // 대댓글설정 parent -> children
        CommentEntity parent = null;
        if(requestDTO.getParent() != null) {
            parent = commentRepository.findById(requestDTO.getParent())
                    .orElseThrow(() -> new RuntimeException("대댓글 부모를 찾을 수 없습니다."));
        }

        // 댓글 저장
        CommentEntity comment = requestDTO.toEntity(parent, user, post);
        return commentRepository.save(comment);
    }

    @Override
    public List<CommentResponseDTO> getCommentsByPostId(Long postId) {

        // 게시글에 해당하는 댓글들 조회
        List<CommentEntity> comments = commentRepository.findByPostId(postId);

        // 댓글들은 commentResponseDTO 로 변환 후 반환
        return comments.stream()
                .map(CommentResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComments(Long commentId) {

        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));

        commentRepository.delete(comment);
    }
}