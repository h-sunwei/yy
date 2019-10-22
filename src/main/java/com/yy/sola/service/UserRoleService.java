package com.yy.sola.service;

import com.yy.sola.pojo.UserAndRole;

import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:04
 * @description:
 */
public interface UserRoleService {

    List<UserAndRole> getListByUserId(String userId);
}
