package com.yy.sola.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 10:39
 * @description:
 */
@Data
@TableName(value = "user")
@ToString
public class User implements Serializable {

    @TableId(value = "user_id",type = IdType.UUID)
    private String userId;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;
}
