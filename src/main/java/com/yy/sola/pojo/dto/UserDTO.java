package com.yy.sola.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: sunwei
 * @date: 2019-09-18
 * @time: 19:40
 * @description:
 */
@Data
@ApiModel(value = "用户dto")
public class UserDTO {

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;
}
