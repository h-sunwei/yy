package com.yy.sola.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author: sunwei
 * @date: 2019-09-26
 * @time: 14:41
 * @description:
 */
@Data
@ToString
@TableName(value = "role_permission")
public class RoleAndPermission {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "role_id")
    private String roleId;

    @TableField(value = "permission_id")
    private String permissionId;
}
