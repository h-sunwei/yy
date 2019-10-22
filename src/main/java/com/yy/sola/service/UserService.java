package com.yy.sola.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.mapper.UserMapper;
import com.yy.sola.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 10:51
 * @description:
 */
public interface UserService {

    void insertUser (User user);

    Page<User> userList();

    User getUser (String userId);

    Page<User> getUserList();

    User getUserByName(String name);
}
