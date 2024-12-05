package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.request.ResumeRequestDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResumeDao {
    List<ResumeResponseDto> getValidResumeListByUserId(String userId);
    int insertResume(@Param("R")ResumeRequestDto resumeRequestDto);
    int maxResumeNo();
    int updateResume(ResumeRequestDto resumeRequestDto);
    int deleteResume(ResumeRequestDto resumeRequestDto);
}
