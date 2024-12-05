package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.IntroduceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IntroduceDao {
    void insertIntroduce(@Param("list") List<IntroduceDto> introduceDtoList);
}
