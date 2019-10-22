package com.yy.sola.pojo.dto;

import com.yy.sola.pojo.Permission;
import com.yy.sola.pojo.Role;
import lombok.Data;
import java.util.Set;


/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 15:22
 * @description:
 */
@Data
public class UserSubjectDTO {

    private String userId;

    private String name;

    private String password;

    private Set<Role> roles;

    private Set<Permission> permissions;
}
