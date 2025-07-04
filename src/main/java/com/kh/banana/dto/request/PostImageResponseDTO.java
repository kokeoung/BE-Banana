package com.kh.banana.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostImageResponseDTO {
    private String imageUrl;

    public static PostImageResponseDTO fromDTO(String imageUrl) {
        return new PostImageResponseDTO(imageUrl);
    }
}