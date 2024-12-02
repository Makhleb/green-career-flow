package com.void2.careermanagement.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

public class CompanyDto {
    private String companyId;
    private String companyPw;
    private String companyName;
    private String companyNumber;
    private String companyInfo;
    private String companyImage;
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
