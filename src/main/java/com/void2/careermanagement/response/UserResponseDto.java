package com.void2.careermanagement.response;

import lombok.Data;

/**
 * Created on 2024-12-03 by 안제연
 */
@Data
public class UserResponseDto {
    private String userName;
    private int userAge;
    //이력서 제목
    private String title;
    private int jobHistory;
    private String skillCode;
    private int likeCount;
    private String skillCodes;
}
