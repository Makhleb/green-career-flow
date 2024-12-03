package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private String userEmail;
    private char userGender;
    private LocalDate userBirth;
    private LocalDateTime userCreateDate;
    private LocalDateTime userModifyDate;
}
