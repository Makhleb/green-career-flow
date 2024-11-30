package com.void2.careermanagement.type;

/**
 * Created on 2024-11-30 by 황승현
 * 구분 테이블 group_code enum
 */
public enum GroupCode {
    SKILL("SKILL"), // 스킬
    WORK("WORK"),  // 직무
    EDUCATION("EDUCATION"), // 최종학력
    MILITARY("MILITARY"), // 복무유형
    JOB_RANK("JOB_RANK"), // 직급/직책
    WORK_TYPE("WORK_TYPE"); // 근무형태

    private String groupCode;

    GroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
}
