package com.void2.careermanagement.type;

import lombok.Getter;

import java.util.Optional;

/**
 * Created on 2024-12-06 by 황승현
 * LikeDao 쓸 때 편하게 쓰려고 만듦
 * 쿼리 동적으로 쓰려고 만듦
 */
@Getter
public enum TblLike {
    // 구직자가 좋아요 했을 때 사용하세용
    U("user_id", "company_id"),
    
    // 기업이 좋아요 했을 때 사용하세용
    C("company_id", "user_id");
    
    private final String inputColumn;
    private final String receiveColumn;

    TblLike(String inputColumn, String receiveColumn) {
        this.inputColumn = inputColumn;
        this.receiveColumn = receiveColumn;
    }

    public static Optional<TblLike> findEnum(String enumName) {
        for (TblLike like : TblLike.values()) {
//            equalsIgnoreCase : 이거 써야 대소문자 비교 안함 \^o^/
            if (like.getInputColumn().equalsIgnoreCase(enumName)) {
                return Optional.of(like);
            }
        }
        return Optional.empty();
    }
}
