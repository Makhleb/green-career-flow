package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.CompanyAccountDao;
import com.void2.careermanagement.dto.CompanyDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyAccountService {

    private final CompanyAccountDao companyAccountDao;

    @Autowired
    public CompanyAccountService(CompanyAccountDao companyAccountDao) {
        this.companyAccountDao = companyAccountDao;
    }

    /**
     * 사용자 정보 업데이트
     * 세션이 존재하지 않을시 false 반환
     * @return 업데이트 성공 여부
     */
    public boolean updateCompany(CompanyDto company, HttpSession session) {
        CompanyDto companySession = (CompanyDto) session.getAttribute("user");
        if (companySession == null) {
            return false;
        }
        if (!companySession.getCompanyId().equals(company.getCompanyId())) {
            return false;
        }
        return companyAccountDao.companyUpdate(company) != 0;
    }

    /**
     * 사용자 삭제
     * 세션이 존재하지 않을시 false 반환
     * @return 업데이트 성공 여부
     */
    public boolean deleteCompany(String companyId, HttpSession session) {

        CompanyDto companySession = (CompanyDto) session.getAttribute("user");
        if (companySession == null) {
            return false;
        }
        if (!companySession.getCompanyId().equals(companyId)) {
            return false;
        }
        if (companyAccountDao.companyDelete(companyId) != 0) {
            session.removeAttribute("company");
            return true;
        }
        return false;
    }
}
