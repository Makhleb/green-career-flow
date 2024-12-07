package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.UserSkillMatchingResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Mapper
public interface UserSkillMatchingDao {

    public List<UserSkillMatchingResponseDto> getRecentJobPostList();
    public List<UserSkillMatchingResponseDto> getSkillTypePostList(String skillCode);
//    List<GubnDto> getSkillListByJobPostNo(int jobPostNo);
}
