package com.qglt.test.service;

import com.qglt.test.dao.UserMapper;
import com.qglt.test.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qingt on 2019/6/26.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Integer userId) {
        return userMapper.queryById(userId);
    }
}
