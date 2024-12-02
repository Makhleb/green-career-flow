package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.GubnDao;
import com.void2.careermanagement.dto.GubnDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-01 by 황승현
 */
@Service
public class GubnService {
    private final GubnDao gubnDao;

    public GubnService(GubnDao gubnDao) {
        this.gubnDao = gubnDao;
    }

    public List<GubnDto> getGubnList(String groupCode) {
        return gubnDao.getGubnList(groupCode);
    };
}
