package com.void2.careermanagement.service;


import com.void2.careermanagement.dao.CompanyDao;
import com.void2.careermanagement.dao.GubnDao;
import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.GubnDto;
import com.void2.careermanagement.response.CompanyResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */
@Service
public class CompanyService {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<CompanyResponseDto> getHighRatingCompanyList() {
        return companyDao.getHighRatingList();
    };

    public List<CompanyResponseDto> getFastDeadLineList() {
        return companyDao.getFastEndDateList();
    };

    public List<CompanyResponseDto> getLikeCompanyList(String id) {return companyDao.getLikeList(id);}
}
