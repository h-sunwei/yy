package com.yy.sola.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: sunwei
 * @date: 2019-09-18
 * @time: 15:31
 * @description:
 */
@RestController
public class QuartzController {
    //注入任务调度
    @Resource
    private Scheduler scheduler;

    @RequestMapping("moni")
    public String moni() throws SchedulerException, ClassNotFoundException {
        QuartzBean quartzBean = new QuartzBean();
        quartzBean.setJobClass("com.yy.sola.quartz.MyQuartzTask");
        quartzBean.setJobName("myQuartzTask");
        quartzBean.setCronExpression("0 0 16 30 * ?");
        QuartzUtils.createScheduleJob(scheduler,quartzBean);
        return "ok";
    }


    @PostMapping("/create")
    @ResponseBody
    public String createJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        QuartzUtils.createScheduleJob(scheduler,quartzBean);
        return "已创建任务";//这里return不是生产级别代码，测试简单写一下
    }

    @RequestMapping("/pause")
    public String pauseJob(String jobName) throws SchedulerException {
        QuartzUtils.pauseScheduleJob (scheduler,"myQuartzTask");
        return "已暂停成功";//这里return不是生产级别代码，测试简单写一下
    }

    @RequestMapping("/run")
    @ResponseBody
    public String runOnce(String jobName) throws SchedulerException {
        QuartzUtils.runOnce (scheduler,"myQuartzTask");
        return "运行任务" + jobName + "成功";//这里return不是生产级别代码，测试简单写一下
    }

    @RequestMapping("/resume")
    @ResponseBody
    public String resume() throws SchedulerException {
        QuartzUtils.resumeScheduleJob(scheduler,"myQuartzTask");
        return "恢复定时任务成功：" + "myQuartzTask";
    }

    @RequestMapping("/update1")
    @ResponseBody
    public String update1(@RequestParam(value = "ss") String ss) throws SchedulerException {
        QuartzBean quartzBean = new QuartzBean();
        quartzBean.setJobClass("com.yy.sola.quartz.MyQuartzTask");
        quartzBean.setJobName("myQuartzTask");
        quartzBean.setCronExpression(ss);
        QuartzUtils.updateScheduleJob(scheduler,quartzBean);
        return "更新定时任务调度信息成功";
    }

    @RequestMapping("/update2")
    @ResponseBody
    public String update2() throws SchedulerException {
        QuartzBean quartzBean = new QuartzBean();
        quartzBean.setJobClass("com.yy.sola.quartz.QuartzSimpleTask");
        quartzBean.setJobName("myJobTrigger");
        quartzBean.setCronExpression("*0 12 16 * * ?");
        QuartzUtils.updateScheduleJob(scheduler,quartzBean);
        return "更新定时任务调度信息成功";
    }

}
