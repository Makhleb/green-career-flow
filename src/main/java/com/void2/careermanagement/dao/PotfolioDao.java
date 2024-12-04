package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.PotfolioDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PotfolioDao {
    int insertPotfolio(@Param("P")PotfolioDto potfolioDto);
}
