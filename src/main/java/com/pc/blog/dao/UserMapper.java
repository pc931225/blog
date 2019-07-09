package com.pc.blog.dao;

import com.pc.blog.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface UserMapper extends BaseMapper<User,Integer>{

    /**
     * 根据账号密码查询账号
     * @param userName 账号
     * @param pwd 密码
     * @return User
     */
    User queryUser(String userName, String pwd);
}