package com.yy.sola.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.sola.pojo.User;
import com.yy.sola.pojo.dto.UserDTO;
import com.yy.sola.service.UserService;
import com.yy.sola.support.CustomResponse;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.Name;
import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 11:09
 * @description:
 */
@Api(tags="用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


   // @ApiOperation(value = "添加用户", notes = "添加新的用户",tags = "User",httpMethod = "POST")
   // @ApiImplicitParams({
            //@ApiImplicitParam(name = "name", value = "名称", required = true,paramType = "query"),
            //@ApiImplicitParam(name = "password", value = "密码", required = true,paramType = "query")

    //})

    //@ApiResponses({
        //    @ApiResponse(code=1001,message="用户名称重复",response=CustomResponse.class),
        //    @ApiResponse(code=1002,message="密码错误",response=CustomResponse.class)
   // })

    @RequestMapping("/saveUser")
    public CustomResponse saveUser(){
        User user = new User();
        user.setName("yy");
        user.setPassword("yy123");
        userService.insertUser(user);
        return CustomResponse.ok();
    }

    @RequestMapping("/getUsers")
    public CustomResponse getUsers(){
        Page<User> page = userService.getUserList();
        return CustomResponse.ok(page);
    }

}
