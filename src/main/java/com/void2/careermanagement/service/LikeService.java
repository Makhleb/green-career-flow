package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.LikeDao;
import com.void2.careermanagement.type.TblLike;
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

    /**
     * 좋아요인지 좋아요 취소인지 체크 후 넣어주는 함수입니당 ╰(*°▽°*)╯
     * @param inputId gubn에 맞게 넣어주세용
     * @param likeId gubn에 맞게 넣어주세용
     * @param gubn 구직자가 좋아요 누르면 'U' 기업이 좋아요 누르면 'C'
     * @return
     */
    public int insertOrDelete(String inputId, String likeId, String gubn) {
        try {
//            String inputColumnName = gubn.equals("U") ? "user_id" : "company_id";
//            String receiveColumnName = gubn.equals("U") ? "company_id" : "user_id";

            TblLike likeGubn = TblLike.findEnum(gubn).orElse(null);
            
            // gubn 값으로 이상한 값 넘어오면 바로 리턴
            if(likeGubn == null) return 0;

            // 등록한 거 없으면 true
            boolean checkLike = likeDao.checkLike(likeGubn.getInputColumn(), inputId, likeGubn.getReceiveColumn(), likeId, likeGubn.name()) == 0;

            if(checkLike) {
                likeDao.insert(likeGubn.getInputColumn(), inputId, likeGubn.getReceiveColumn(), likeId, likeGubn.name());
            } else {
                likeDao.delete(likeGubn.getInputColumn(), inputId, likeGubn.getReceiveColumn(), likeId, likeGubn.name());
            }

            return 1;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
