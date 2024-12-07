package com.void2.careermanagement.service;


import com.void2.careermanagement.dao.CompanyDao;
import com.void2.careermanagement.dao.JobPostDao;
import com.void2.careermanagement.dto.response.CompanyResponseDto;
import com.void2.careermanagement.type.GroupCode;
import com.void2.careermanagement.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2024-12-02 by 안제연
 */
@Service
public class CompanyService {
    private final CompanyDao companyDao;
    private final JobPostDao jobPostDao;

    @Autowired
    public CompanyService(CompanyDao companyDao, JobPostDao jobPostDao) {
        this.companyDao = companyDao;
        this.jobPostDao = jobPostDao;
    }

    public List<CompanyResponseDto> getHighRatingCompanyList() {
        return setImageEncodeBase64(companyDao.getHighRatingList());
    }

    public List<CompanyResponseDto> getFastDeadLineList() {
        return setImageEncodeBase64(companyDao.getFastEndDateList());
    }

    ;

    public List<CompanyResponseDto> getLikeCompanyList(String id) {
        return setImageEncodeBase64(companyDao.getLikeList(id));
    }

    public CompanyResponseDto getCompanyInfoById(String id) {
        CompanyResponseDto companyInfo = companyDao.getCompanyInfoById(id);

        if (companyInfo.getCompanyImage() != null) {
            companyInfo.setCompanyImageBase64(ImageUtil.encodeToBase64(companyInfo.getCompanyImage()));
        }

        List<GroupCode> gubnList = new ArrayList<>();

        gubnList.add(GroupCode.WORK_TYPE);
        gubnList.add(GroupCode.WORK);
        gubnList.add(GroupCode.EDUCATION);
        gubnList.add(GroupCode.JOB_RANK);

        companyInfo.setJobPostList(jobPostDao.getJobPostListByCompanyId(id, gubnList.stream().map(Enum::name).toList()));
        return companyInfo;
    }

    public List<CompanyResponseDto> setImageEncodeBase64(List<CompanyResponseDto> companyList) {
        companyList.forEach(company -> {
            if (company.getCompanyImageBase64() != null) {
                company.setCompanyImageBase64(ImageUtil.encodeToBase64(company.getCompanyImage()));
            }
        });
        return companyList;
    }
}
