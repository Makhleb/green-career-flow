package com.void2.careermanagement.dao;


import com.void2.careermanagement.dto.response.CompanyResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */

@Mapper
public interface CompanyDao {
    public List<CompanyResponseDto> getHighRatingList();
    public List<CompanyResponseDto> getFastEndDateList();
    public List<CompanyResponseDto> getLikeList(String id);

}
