package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.RatingDao;
import org.springframework.stereotype.Service;

/**
 * Created on 2024-12-08 by 황승현
 */
@Service
public class RatingService {
    private final RatingDao ratingDao;

    public RatingService(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    public int insert(String companyId, int score, String sessionUserId) {
        try {
            ratingDao.delete(companyId, sessionUserId);
            ratingDao.insert(companyId, sessionUserId, score);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getUserRating(String companyId, String userId) {
        try {
            return ratingDao.getUserRating(companyId, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
