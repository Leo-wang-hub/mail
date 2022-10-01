package com.woomq.service.Impl;

import com.woomq.mapper.TypeMapper;
import com.woomq.mapper.UserMapper;
import com.woomq.pojo.User;
import com.woomq.service.TypeService;
import com.woomq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author woo-mq
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public int addUser(User user) {
        userMapper.addUser(user);
        return 1;
    }
}
