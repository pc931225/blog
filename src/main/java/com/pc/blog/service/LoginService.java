package com.pc.blog.service;

import com.pc.blog.model.User;

/**
 *
 * @author pc
 **/
public interface LoginService {

    User login(String userName, String pwd);
}
