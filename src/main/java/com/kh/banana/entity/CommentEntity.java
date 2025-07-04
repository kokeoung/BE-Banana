package com.kh.banana.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Table(name="comment")
@Entity
@Getter
public class CommentEntity extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    // 댓글관리
    // 대댓글이 없으면 최상위 댓글
    // 대댓글이 달리면 그 시점부터 대댓글의 부모댓글
    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = true)
    private CommentEntity parent;

    // 대댓글관리
    // cascade 로 부모가 삭제되면 자식도 삭제,
    // orphanRemoval = true 로 부모 컬렉션에서 자식 제거 시 DB 에서 자동 삭제
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> children = new ArrayList<>();

    public static CommentEntity of(String content, CommentEntity parent, UserEntity user, PostEntity post) {
        CommentEntity comment = new CommentEntity();
        comment.content = content;
        comment.parent = parent;
        comment.user = user;
        comment.post = post;
        return comment;
    }
}