package com.yy.sola.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.PermissionMapper;
import com.yy.sola.pojo.Permission;
import com.yy.sola.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:02
 * @description:
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
