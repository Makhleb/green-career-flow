package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.MyPageDao;
import com.void2.careermanagement.dto.response.MyPageScrapDto;
import com.void2.careermanagement.dto.response.ResumeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-04 by 최윤서
 */
@Service
public class MyPageService {
    @Autowired
    private MyPageDao myPageDao;

    public List<ResumeResponseDto> MyPageResumeListById(String userId) {
        return myPageDao.MyPageResumeListById(userId);
    }

    public List<MyPageScrapDto> MyPageScrapListById(String userId) {
        return myPageDao.MyPageScrapListById(userId);
    }
}
