package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserInterestCompanyDao;
import com.void2.careermanagement.dto.response.UserInterestCompanyDto;
import com.void2.careermanagement.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-05 by 안제연
 */
@Service
public class UserInterestCompanyService {
    private final UserInterestCompanyDao userInterestCompanyDao;

    @Autowired
    public UserInterestCompanyService(UserInterestCompanyDao userInterestCompanyDao) {
        this.userInterestCompanyDao = userInterestCompanyDao;
    }

    //관심기업 조회
    public List<UserInterestCompanyDto> getUserInterestCompanyList(String id) {
        List<UserInterestCompanyDto> companyInfo = userInterestCompanyDao.getInterestList(id);
        for (UserInterestCompanyDto company : companyInfo) {
            if (company.getCompanyImage() != null) {
                company.setCompanyImageBase64(ImageUtil.encodeToBase64(company.getCompanyImage()));
            }
        }
        return companyInfo;
    }

    //관심기업 삭제
    public void removeUserInterestCompany(String companyId, String userId) {
        userInterestCompanyDao.deleteInterestCompany(companyId, userId);
    }

}
