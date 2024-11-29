package com.void2.careermanagement.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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
