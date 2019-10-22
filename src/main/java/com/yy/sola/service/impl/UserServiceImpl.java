package com.yy.sola.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.sola.event.UserRegisterEvent;
import com.yy.sola.mapper.UserMapper;
import com.yy.sola.pojo.User;
import com.yy.sola.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 10:51
 * @description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    @Transactional
    public void insertUser(User user) {
        this.save(user);
        applicationContext.publishEvent(new UserRegisterEvent(this,user));
    }

    @Override
    public Page<User> userList() {
        Page<User> page = new Page<User>(1,5);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name","yy12");
        return (Page<User>) this.page(page,queryWrapper);
    }

    @Override
    public User getUser(String userId) {
        return userMapper.getUser(userId);
    }

    @Override
    @Cacheable(value = "userList" ,key = "targetClass + methodName")
    public Page<User> getUserList() {
        Page<User> page = new Page<User>(1,5);
        List<User> list = userMapper.getUserList(page);
        page.setRecords(list);
        return page;
    }

    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        return this.getOne(queryWrapper);
    }
}
