package com.kh.banana.dto.request;

import com.kh.banana.entity.CommentEntity;
import com.kh.banana.entity.PostEntity;
import com.kh.banana.entity.UserEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRequestDTO {

    // 유저와 게시글은 서비스 계층에서 처리할 예정
    // 댓글 내용만 설정, 로그인 시 서버에서 이미 유저를 알고있기 때문에 세션에서 유저정보를 가져올수있음
    private Long parent;
    private String content;

    public CommentEntity toEntity(CommentEntity parent, UserEntity user, PostEntity post) {
        return CommentEntity.of(this.content, parent, user, post);
    }
}
