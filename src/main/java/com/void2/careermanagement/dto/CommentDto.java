package com.void2.careermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2024-12-03 by 최윤서
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private int commentNo;
    private int communityNo;
    private String userId;
    private String commentContent;
    private String commentCreateDate;
    private String commentModifyDate;

}
