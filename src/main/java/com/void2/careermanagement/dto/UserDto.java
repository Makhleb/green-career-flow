package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String user_id;
    private String user_pw;
    private String user_name;
    private String user_phone;
    private String user_email;
    private char user_gender;
    private String user_birth;
    private LocalDateTime user_create_date;
    private LocalDateTime user_modify_date;
}
