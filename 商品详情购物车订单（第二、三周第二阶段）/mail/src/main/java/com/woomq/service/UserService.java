package com.woomq.service;

import com.woomq.pojo.User;

/**
 * @author  woo-mq
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return User
     */
    User getUserByUserName(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);
}
