package com.yy.sola.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author: sunwei
 * @date: 2019-09-18
 * @time: 15:30
 * @description:
 */
@DisallowConcurrentExecution
public class MyQuartzTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("这是动态定时任务在执行："+new Date());
    }
}
