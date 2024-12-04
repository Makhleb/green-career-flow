package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.IntroduceDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IntroduceDao {
    int insertIntroduce(@Param("I")IntroduceDto introduceDto);
}
