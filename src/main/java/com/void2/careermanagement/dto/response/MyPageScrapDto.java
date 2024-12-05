package com.void2.careermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageScrapDto {
        private String userId;                          // user_id
        private int jobPostNo;                          // job_post_no
        private String title;                           // title
        private LocalDateTime endDate;                  // end_date
        private String companyId;                       // company_id
        private String companyName;                     // company_name
        private LocalDateTime scrapDate;                // scrap_date
    }
