package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.java.entity.UserInfo;

@Mapper
public interface UserInfoMapper {

    UserInfo findUser(@Param("uname") String uname);

}
