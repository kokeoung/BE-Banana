package com.kh.banana.dto.response;

import java.time.LocalDateTime;

import com.kh.banana.entity.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostIdResponseDTO {
    private Long id;

    public static PostIdResponseDTO fromEntity(PostEntity entity) {
        return new PostIdResponseDTO(
                entity.getId());

    }
}