package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.request.ApplyRequestDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created on 2024-12-04 by 황승현
 */
@Mapper
public interface ApplyDao {
    int insert(ApplyRequestDto applyDto);

    int checkApply(String userId, int jobPostNo);

}
