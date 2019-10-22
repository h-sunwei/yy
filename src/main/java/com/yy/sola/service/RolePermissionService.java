package com.yy.sola.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.RolePermissionMapper;
import com.yy.sola.pojo.RoleAndPermission;

import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:06
 * @description:
 */
public interface RolePermissionService {

    List<RoleAndPermission> getListByRoleId(String roleId);
}
