package com.yy.sola.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author: sunwei
 * @date: 2019-09-17
 * @time: 15:36
 * @description:
 */
@DisallowConcurrentExecution
public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("简单的定时任务执行时间："+new Date());
    }
}
