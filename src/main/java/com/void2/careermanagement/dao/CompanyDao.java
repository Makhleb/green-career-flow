package com.void2.careermanagement.dao;


import com.void2.careermanagement.dto.CompanyDto;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */
public interface CompanyDao {
    public List<CompanyDto> getHighRatingList();

}
