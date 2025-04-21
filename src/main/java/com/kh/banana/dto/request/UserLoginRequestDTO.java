package com.kh.banana.dto.request;

import com.kh.banana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginRequestDTO {

    private String userId;
    private String userPass;

    public static UserEntity toEntity(UserLoginRequestDTO dto) {
        return UserEntity.createUserForLogin(dto.getUserId(), dto.getUserPass());
    }
}
