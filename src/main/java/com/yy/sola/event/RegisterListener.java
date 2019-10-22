package com.yy.sola.event;

import com.yy.sola.pojo.User;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: sunwei
 * @date: 2019-09-19
 * @time: 16:39
 * @description:
 */
@Component
public class RegisterListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        User user = event.getUser();
        System.out.println("hhhh"+user.toString());
    }
}
