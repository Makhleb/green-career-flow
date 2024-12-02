package com.void2.careermanagement.dto;

import lombok.Data;

// todo UserDto와 곂침.UserDto에 annotation 추가하고 이건 삭제합시다.
@Data
public class UserLoginDto {
    private String userId;
    private String userPw;
}
