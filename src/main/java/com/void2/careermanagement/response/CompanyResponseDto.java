package com.void2.careermanagement.response;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created on 2024-12-02 by 안제연
 */

@Data
public class CompanyResponseDto {
    private String companyName;
    private String companyAddress;
    private String title;
    private String startDate;
    private String endDate;
    private String companyImage;
    private int jobHistory;
    private double rating;
    private int jobPostNo;
    private char likeYN; // 좋아요 했으면 유저가 기업 관심한 거 Y
}
