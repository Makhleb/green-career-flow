package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.PotfolioDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PotfolioDao {
    int insertPotfolio(@Param("list") List<PotfolioDto> potfolioDtoList);
}
