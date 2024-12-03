package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.LikeDao;
import org.springframework.stereotype.Service;

/**
 * Created on 2024-12-03 by 황승현
 */
@Service
public class LikeService {
    private final LikeDao likeDao;

    public LikeService(LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    public int insertOrDelete(String inputId, String likeId, String gubn) {
        try {
            String inputColumnName = gubn.equals("U") ? "user_id" : "company_id";
            String receiveColumnName = gubn.equals("U") ? "company_id" : "user_id";

            // 등록한 거 없으면 true
            boolean checkLike = likeDao.checkLike(inputColumnName, inputId, receiveColumnName, likeId, gubn) == 0;

            if(checkLike) {
                likeDao.insert(inputColumnName, inputId, receiveColumnName, likeId, gubn);
            } else {
                likeDao.delete(inputColumnName, inputId, receiveColumnName, likeId, gubn);
            }

            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
