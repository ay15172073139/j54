package org.java.service.Impl;

import org.java.dao.UserInfoMapper;
import org.java.entity.UserInfo;
import org.java.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo findUser(String uname) {
        return userInfoMapper.findUser(uname);
    }
}
