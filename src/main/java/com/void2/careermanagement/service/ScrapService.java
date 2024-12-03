package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.ScrapDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2024-12-03 by 황승현
 */
@Service
public class ScrapService {
    private final ScrapDao scrapDao;

    public ScrapService(ScrapDao scrapDao) {
        this.scrapDao = scrapDao;
    }

    public int insertOrDelete(String userId, int jobPostNo) {
        try {
            if (scrapDao.checkScrap(userId, jobPostNo) > 0) {
                scrapDao.delete(userId, jobPostNo);
            } else {
                scrapDao.insert(userId, jobPostNo);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}
