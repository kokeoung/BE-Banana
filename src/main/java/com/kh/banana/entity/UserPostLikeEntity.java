package com.kh.banana.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="post_like", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "post_id"})) // 중복좋아요 방지)
@Entity
@Getter
@Setter
public class UserPostLikeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)  // Post 외래 키
    private PostEntity post;

    public static UserPostLikeEntity from(UserEntity user, PostEntity post) {
        if (user == null) {
            throw new IllegalArgumentException("먼저 로그인 하세요");
        }
        UserPostLikeEntity dao = new UserPostLikeEntity();
        dao.setUser(user);
        dao.setPost(post);
        return dao;
    }
}
