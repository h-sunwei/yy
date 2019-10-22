package com.yy.sola.event;

import com.yy.sola.pojo.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author: sunwei
 * @date: 2019-09-19
 * @time: 16:16
 * @description: 事件监听
 */
@Data
public class UserRegisterEvent extends ApplicationEvent {

    //注册用户对象
    private User user;

    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
