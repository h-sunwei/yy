package com.yy.sola.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.RolePermissionMapper;
import com.yy.sola.pojo.RoleAndPermission;
import com.yy.sola.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:07
 * @description:
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RoleAndPermission> implements RolePermissionService {

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RoleAndPermission> getListByRoleId(String roleId) {
        QueryWrapper<RoleAndPermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        return rolePermissionMapper.selectList(queryWrapper);
    }
}
