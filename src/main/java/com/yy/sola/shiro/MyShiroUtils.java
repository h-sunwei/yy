package com.yy.sola.shiro;

import com.yy.sola.pojo.User;
import com.yy.sola.pojo.dto.UserSubjectDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author: sunwei
 * @date: 2019-09-27
 * @time: 14:50
 * @description: shiro工具
 */
public class MyShiroUtils {

    /**
     * 获取用户信息
     * @return
     */
    public static UserSubjectDTO getUser() {
        if (null == getSubject() || getSubject().getPrincipal() == null) {
            return null;
        }
        return (UserSubjectDTO)getSubject().getPrincipals().getPrimaryPrincipal();
    }

    public static Subject getSubject () {
        return SecurityUtils.getSubject();
    }

}
