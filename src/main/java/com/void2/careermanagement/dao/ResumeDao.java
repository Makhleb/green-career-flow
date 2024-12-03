package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-04 by 황승현
 */
@Mapper
public interface ResumeDao {

    List<ResumeResponseDto> getListById(String userId);
}
