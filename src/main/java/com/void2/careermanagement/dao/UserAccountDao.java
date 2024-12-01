package com.void2.careermanagement.dao;

import com.void2.careermanagement.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 유저 계정 관리 DAO
 */
@Mapper
public interface UserAccountDao {
    UserDto loginUserSelect(@Param("user_id") String user_id, @Param("user_pw") String user_pw);
    int userInsert(@Param("U") UserDto userDto);
    int findUserIdSelect(@Param("user_id") String user_id);
}
