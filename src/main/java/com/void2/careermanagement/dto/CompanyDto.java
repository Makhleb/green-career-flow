package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
    private Date companyBirth;
    private int companyEmployee;
    private LocalDate companyCreateDate;
    private LocalDate companyModifyDate;
}
