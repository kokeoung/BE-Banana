package com.kh.banana.dto.response;

import com.kh.banana.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponseDTO {

    private Long commentId;
    private String content;
    private String userNick;
    private String userProfileImage;
    private List<CommentResponseDTO> children = new ArrayList<>();

    public static CommentResponseDTO fromEntity(CommentEntity commentEntity) {
        // 자식 댓글(대댓글) 리스트 변환
        List<CommentResponseDTO> children = commentEntity.getChildren().stream()
                .map(CommentResponseDTO::fromEntity)
                .collect(Collectors.toList());

        // CommentResponseDTO 객체 생성 후 반환
        return new CommentResponseDTO(
                commentEntity.getId(),
                commentEntity.getContent(),
                commentEntity.getUser().getUserNick(),
                commentEntity.getUser().getUserProfileImage(),
                children
        );
    }
}
