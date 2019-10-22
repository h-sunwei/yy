package com.yy.sola.shiro;

import com.yy.sola.converter.UserSubjectConverter;
import com.yy.sola.pojo.Permission;
import com.yy.sola.pojo.Role;
import com.yy.sola.pojo.User;
import com.yy.sola.pojo.dto.UserSubjectDTO;
import com.yy.sola.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 9:13
 * @description:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSubjectConverter userSubjectConverter;

    /**
     * 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserSubjectDTO userSubjectDTO = (UserSubjectDTO) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<Permission> permissionSet = userSubjectDTO.getPermissions();
        Set<String> p = permissionSet.stream().map(permission -> {
            return permission.getName();
        }).collect(Collectors.toSet());
        Set<Role> roleSet = userSubjectDTO.getRoles();
        Set<String> r = roleSet.stream().map(role -> {
            return role.getName();
        }).collect(Collectors.toSet());
        info.addStringPermissions(p);
        info.addRoles(r);
        return info;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        UserSubjectDTO userSubjectDTO = new UserSubjectDTO();
        String name = usernamePasswordToken.getUsername();
        User user = userService.getUserByName(name);
        if (null != user) {
            userSubjectDTO = userSubjectConverter.convert(user);
        }else {
            //找不到当前账号用户
            throw new AuthenticationException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userSubjectDTO, userSubjectDTO.getPassword(), getName());
        return authenticationInfo;
    }
}
