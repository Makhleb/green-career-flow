package com.void2.careermanagement.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */

@Data
public class CompanyResponseDto {
    private String companyName;
    private String companyAddress;
    private String companyAddressDetail;
    private String companyZonecode;
    private String companyInfo;
    private String companyWebsite;
    private int companyEmployee;
    private String title;
    private String startDate;
    private String endDate;
    private int jobHistory;
    private double rating;
    private int jobPostNo;
    private char likeYN; // 좋아요 했으면 유저가 기업 관심한 거 Y
    private List<JobPostResponseDto> jobPostList;
    private byte[] companyImage;
    private String companyImageBase64;
}
