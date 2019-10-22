package com.yy.sola.quartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: sunwei
 * @date: 2019-09-17
 * @time: 15:39
 * @description:
 */
//@Configuration
public class QuartzSimpleConfig {

    // 使用jobDetail包装QuartzSimpleTask
    //@Bean
    //public JobDetail myJobDetail() {
       // return JobBuilder.newJob(QuartzSimpleTask.class).withIdentity("quartzSimpleTask").storeDurably().build();
    //}

    // 把jobDetail注册到trigger上去
    //@Bean
   // public Trigger myJobTrigger() {
    //    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/30 * * * * ?");
     //   return TriggerBuilder.newTrigger()
     //           .forJob(myJobDetail())
     //           .withIdentity("myJobTrigger")
     //           .withSchedule(scheduleBuilder)
     //           .build();
   // }


}
