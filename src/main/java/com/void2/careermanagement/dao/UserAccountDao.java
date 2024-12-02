package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 유저 계정 관리 DAO
 */
@Mapper
public interface UserAccountDao {
    UserDto loginUserSelect(@Param("userId") String userId, @Param("userPw") String userPw);
    int userInsert(@Param("U") UserDto userDto);
    int findUserIdSelect(@Param("userId") String userId);
    int userUpdate(@Param("U") UserDto userDto);
    int userDelete(String userId);
    UserDto sessionSelect(@Param("userId") String userId);
}
