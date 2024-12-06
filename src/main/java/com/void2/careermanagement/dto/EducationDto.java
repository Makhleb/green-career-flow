package com.void2.careermanagement.dto;


import lombok.Data;

@Data
public class EducationDto {
    private int resumeNo;
    private String educationCode;
    private String schoolName;
    private String specialty;
    private String enterDate;
    private String graduateDate;
}