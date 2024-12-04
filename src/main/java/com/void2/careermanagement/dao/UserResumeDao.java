package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.UserResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-03 by 안제연
 */
@Mapper
public interface UserResumeDao {
    public List<UserResponseDto> getHighLikeUserList();
}
