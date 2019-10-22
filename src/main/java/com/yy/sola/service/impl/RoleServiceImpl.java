package com.yy.sola.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.RoleMapper;
import com.yy.sola.pojo.Role;
import com.yy.sola.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:00
 * @description:
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
