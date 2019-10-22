package com.yy.sola.quartz;

import lombok.Data;

/**
 * @author: sunwei
 * @date: 2019-09-18
 * @time: 15:22
 * @description:
 */
@Data
public class QuartzBean {

    /** 任务id */
    private String id;

    /** 任务名称 */
    private String jobName;

    /** 任务执行类 */
    private String jobClass;

    /** 任务状态 启动还是暂停*/
    private Integer status;

    /** 任务运行时间表达式 */
    private String cronExpression;
}
