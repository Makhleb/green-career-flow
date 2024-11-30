package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.JobPostDto;
import com.void2.careermanagement.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SampleDao {
    List<UserDto> selectUser();

    List<JobPostDto> selectJobPostWithDynamicJoin(@Param("jobPostNo") int jobPostNo, @Param("gubnList") List<String> gubnList);
}
