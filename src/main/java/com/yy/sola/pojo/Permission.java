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
 * @time: 9:40
 * @description:  权限菜单
 */
@Data
@ToString
@TableName(value = "permission")
public class Permission {

    @TableId(value = "permission_id",type = IdType.UUID)
    private String permissionId;

    @TableField(value = "name")
    private String name;
}
