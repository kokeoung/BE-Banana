package com.kh.banana.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="follow")
@Entity
@Getter
@Setter
public class FollowEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_user_id")
    private UserEntity follower;

    @ManyToOne
    @JoinColumn(name = "followed_user_id")
    private UserEntity followed;
}
