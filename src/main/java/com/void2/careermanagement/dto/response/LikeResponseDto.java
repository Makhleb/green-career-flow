package com.void2.careermanagement.dto.response;

import lombok.Data;

/**
 * Created on 2024-12-06 by 황승현
 */
@Data
public class LikeResponseDto {
    private int userId;
    private String userName;
    private int resumeNo;
    private String jobHistory;
    private int userAge;
}
