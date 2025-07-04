package com.kh.banana.controller;

import com.kh.banana.dto.request.CommentRequestDTO;
import com.kh.banana.dto.response.CommentResponseDTO;
import com.kh.banana.entity.CommentEntity;
import com.kh.banana.service.impl.CommentImplService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentImplService commentImplService;

    // 댓글 저장 후, 최신 댓글 목록 반환(갱신)
    @PostMapping("/{postId}")
    public List<CommentResponseDTO> createComment(
            @PathVariable(value = "postId") Long postId,
            @RequestBody CommentRequestDTO requestDTO,
            @RequestHeader("X-USER-ID") Long userId
    ) {
        commentImplService.saveComment(requestDTO, postId, userId);
        return commentImplService.getCommentsByPostId(postId);
    }

    // 특정 게시글의 전체 댓글 조회
    @GetMapping("/{postId}")
    public List<CommentResponseDTO> getComments(@PathVariable(value = "postId") Long postId) {
        return commentImplService.getCommentsByPostId(postId);
    }

    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(
            @PathVariable Long commentId,
            @RequestHeader("X-USER-ID") Long userId) {
        commentImplService.deleteComments(commentId);
    }

}