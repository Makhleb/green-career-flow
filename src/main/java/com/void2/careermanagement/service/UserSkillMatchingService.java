package com.void2.careermanagement.service;

import com.void2.careermanagement.dao.UserSkillMatchingDao;
import com.void2.careermanagement.dto.response.UserSkillMatchingResponseDto;
import com.void2.careermanagement.util.ImageUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2024-12-05 by 최윤서
 */
@Service
public class UserSkillMatchingService {
    private final UserSkillMatchingDao userSkillMatchingDao;

    public UserSkillMatchingService(UserSkillMatchingDao userSkillMatchingDao) {
        this.userSkillMatchingDao = userSkillMatchingDao;
    }

    public List<UserSkillMatchingResponseDto> getRecentJobPostList(){
        List<UserSkillMatchingResponseDto> list = userSkillMatchingDao.getRecentJobPostList();
        return list;
    }

    public List<UserSkillMatchingResponseDto> getSkillTypePostList(String skillCode){
        List<UserSkillMatchingResponseDto> list = userSkillMatchingDao.getSkillTypePostList(skillCode);

        list.forEach(val -> {
            val.setCompanyImageBase64(ImageUtil.encodeToBase64(val.getCompanyImage()));
        });
//        for (int i = 0; i < list.size(); i++) {
//            list.get(i).setSkillList(userSkillMatchingDao.getSkillListByJobPostNo(list.get(i).getJobPostNo()));
//        }
//        for(UserSkillMatchingResponseDto dto : list){
//            System.out.println(dto);
//        }
        return list;
    }
}
