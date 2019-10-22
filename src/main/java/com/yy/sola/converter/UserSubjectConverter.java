package com.yy.sola.converter;

import cn.hutool.core.collection.CollUtil;
import com.yy.sola.mapper.PermissionMapper;
import com.yy.sola.mapper.RoleMapper;
import com.yy.sola.mapper.RolePermissionMapper;
import com.yy.sola.pojo.*;
import com.yy.sola.pojo.dto.UserSubjectDTO;
import com.yy.sola.service.RolePermissionService;
import com.yy.sola.service.RoleService;
import com.yy.sola.service.UserRoleService;
import com.yy.sola.support.CustomerConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:32
 * @description:
 */
@Component
public class UserSubjectConverter implements CustomerConverter<User, UserSubjectDTO> {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public UserSubjectDTO convert(User user) {
        UserSubjectDTO userSubjectDTO = new UserSubjectDTO();
        Set<Role> roles = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();
        BeanUtils.copyProperties(user,userSubjectDTO);
        List<UserAndRole> list = userRoleService.getListByUserId(user.getUserId());
        if (CollUtil.isNotEmpty(list)) {
            for (UserAndRole userAndRole : list) {
                Role role = roleMapper.selectById(userAndRole.getRoleId());
                roles.add(role);
            }
        }
        if (CollUtil.isNotEmpty(roles)) {
            for (Role role : roles) {
                List<RoleAndPermission> roleAndPermissionList = rolePermissionService.getListByRoleId(role.getRoleId());
                if (CollUtil.isNotEmpty(roleAndPermissionList)) {
                    for (RoleAndPermission roleAndPermission : roleAndPermissionList) {
                        Permission permission = permissionMapper.selectById(roleAndPermission.getPermissionId());
                        permissions.add(permission);
                    }
                }
            }
        }
        userSubjectDTO.setRoles(roles);
        userSubjectDTO.setPermissions(permissions);
        return userSubjectDTO;
    }
}
