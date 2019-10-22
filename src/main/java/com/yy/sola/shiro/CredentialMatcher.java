package com.yy.sola.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import javax.print.DocFlavor;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 17:07
 * @description:
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        String dbpassword = (String)info.getCredentials();
        if (password.equals(dbpassword)) {
            return true;
        }else {
            return false;
        }
    }
}
