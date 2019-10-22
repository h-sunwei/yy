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
 * @time: 9:43
 * @description:
 */
@Data
@ToString
@TableName(value = "user_role")
public class UserAndRole {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "role_id")
    private String roleId;
}
