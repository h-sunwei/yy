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
 * @time: 9:31
 * @description: 用户角色
 */
@Data
@ToString
@TableName(value = "role")
public class Role {

    @TableId(value = "role_id",type = IdType.UUID)
    private String roleId;

    @TableField(value = "name")
    private String name;
}
