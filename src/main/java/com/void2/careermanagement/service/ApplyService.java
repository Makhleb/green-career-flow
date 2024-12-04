package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ApplyDao;
import com.void2.careermanagement.dto.request.ApplyRequestDto;
import org.springframework.stereotype.Service;

/**
 * Created on 2024-12-04 by 황승현
 */
@Service
public class ApplyService {
    private final ApplyDao applyDao;

    public ApplyService(ApplyDao applyDao) {
        this.applyDao = applyDao;
    }

    public int insert(ApplyRequestDto applyDto) {
        try {
            applyDao.insert(applyDto);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
