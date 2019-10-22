package com.yy.sola.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yy.sola.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 10:46
 * @description:
 */
public interface UserMapper extends BaseMapper<User> {

    User getUser (@Param("userId") String userId);

    List<User> getUserList(Page page);

}
