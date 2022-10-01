package com.woomq.mapper;

import com.woomq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author woo-mq
 */
@Mapper
@Repository
public interface UserMapper {
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
