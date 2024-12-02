package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private String companyId;
    private String companyPw;
    private String companyName;
    private String companyNumber;
    private String companyInfo;
    private byte[] companyImage;
    private String companyAddress;
    private String companyAddressDetail;
    private String companyZonecode;
    private String companyContact;
    private String companyWebsite;
    private String companyEmail;
    private LocalDate companyBirth;
    private String companyEmployee;
    private LocalDateTime companyCreateDate;
    private LocalDateTime companyModifyDate;
}
