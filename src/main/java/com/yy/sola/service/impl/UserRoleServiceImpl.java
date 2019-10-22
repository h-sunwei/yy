package com.yy.sola.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.UserRoleMapper;
import com.yy.sola.pojo.UserAndRole;
import com.yy.sola.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:05
 * @description:
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserAndRole> implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserAndRole> getListByUserId(String userId) {
        QueryWrapper<UserAndRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return userRoleMapper.selectList(queryWrapper);
    }
}
