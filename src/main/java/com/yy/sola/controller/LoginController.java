package com.yy.sola.controller;

import com.yy.sola.exception.BusinessException;
import com.yy.sola.exception.CustomExceptionEnum;
import com.yy.sola.shiro.MyShiroUtils;
import com.yy.sola.support.CustomResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: sunwei
 * @date: 2019-09-27
 * @time: 10:53
 * @description:
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "toLogin")
    public String toLogin () {
        if ( MyShiroUtils.getSubject().isAuthenticated()||MyShiroUtils.getUser() != null) {
            //重复登陆
            throw new BusinessException(CustomExceptionEnum.USERACCOUNT_LOGINGING);
        }
        return "login";
    }

    @RequestMapping(value = "doLogin")
    @ResponseBody
    public CustomResponse doLogin (@RequestParam(value = "name") String name,
                                   @RequestParam(value = "password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //执行shiro登录操作
            subject.login(token);
        }
        catch (IncorrectCredentialsException e) {
            throw new BusinessException(CustomExceptionEnum.USERPASSWORD_ERROR);
        }catch (AuthenticationException e) {
            throw new BusinessException(CustomExceptionEnum.USERACCOUNT_NOEXIST);

        }
        return CustomResponse.ok("登陆成功");
    }


}
