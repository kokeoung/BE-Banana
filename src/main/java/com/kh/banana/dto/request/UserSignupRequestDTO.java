package com.kh.banana.dto.request;

import com.kh.banana.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public class UserSignupRequestDTO {

    private String userAccount;
    private String userPass;
    private String userNick;

    // 서비스에서 toEntity() 메소드 호출해서 엔티티로 변환
    // createUserForSignup() 메서드는 UserEntity 객체를 생성하면서 DTO 에서 받은 값을
    // UserEntity 생성자에 전달하여 UserEntity 객체에 값을 할당
    public UserEntity toEntity() {
        return UserEntity.createUserForSignup(this.userAccount, this.userPass, this.userNick);
    }
}
