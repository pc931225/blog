package com.pc.blog.service.impl;

import com.pc.blog.dao.UserMapper;
import com.pc.blog.model.User;
import com.pc.blog.service.LoginService;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 **/
@Service
public class LoginServiceImpl implements LoginService {

    private UserMapper userMapper;

    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User login(String userName, String pwd) {
        return userMapper.queryUser(userName,pwd);
    }
}
