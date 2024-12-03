package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ResumeDao;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-04 by 황승현
 */
@Service
public class ResumeService {
    private final ResumeDao resumeDao;

    public ResumeService(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    public List<ResumeResponseDto> getListByUserId(String userId) {
        return resumeDao.getListById(userId);
    }
}
