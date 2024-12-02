package com.void2.careermanagement.service;


import com.void2.careermanagement.dao.CompanyDao;
import com.void2.careermanagement.dao.GubnDao;
import com.void2.careermanagement.dto.CompanyDto;
import com.void2.careermanagement.dto.GubnDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */
@Service
public class CompanyService {
    private final CompanyDao companyDao;

    public CompanyService(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<CompanyDto> getHighRatingCompanyList() {
        return companyDao.getHighRatingList();
    };
}
