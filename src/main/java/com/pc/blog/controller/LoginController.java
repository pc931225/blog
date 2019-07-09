package com.pc.blog.controller;

import com.pc.blog.model.User;
import com.pc.blog.service.LoginService;
import com.pc.blog.util.MapBeanUtil;
import com.pc.blog.util.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录接口
 * @author pc
 * @date 219/07/08 16:42
 **/
@RestController(value = "loginController")
@RequestMapping(value = "/login")
public class LoginController extends BaseController{

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录接口
     * @param userName 账号
     * @param pwd 密码
     * @param request 请求
     * @return User
     */
    @RequestMapping(value = "/login",produces = "text/html;charset=UTF-8",method = RequestMethod.POST)
    public Object login(String userName, String pwd, HttpServletRequest request){
        if(StringUtil.isNull(userName)){
            return getErrorJson("userName不能为空!");
        }
        if(StringUtil.isNull(pwd)){
            return getErrorJson("pwd不能为空!");
        }

        User user=loginService.login(userName,pwd);
        boolean result=false;
        if(user!=null && user.getRole()==1){
            setUser(request, MapBeanUtil.object2Map(user));
            setUserId(request,user.getId());
            result=true;
        }
        return getJson(result,"");
    }

}
