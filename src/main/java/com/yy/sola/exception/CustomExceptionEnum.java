package com.yy.sola.exception;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 11:25
 * @description: 错误信息枚举
 */
public enum CustomExceptionEnum {
    //用户名密码错误
    USERPASSWORD_ERROR(1001,"密码错误"),
    //账户不存在
    USERACCOUNT_NOEXIST(1002,"账号不存在"),
    //账号已登录
    USERACCOUNT_LOGINGING(1003,"账号已登录");

    private int code;
    private String desc;

    private CustomExceptionEnum (int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CustomExceptionEnum getByCode(int code) {
        CustomExceptionEnum[] values = values();
        for (CustomExceptionEnum sw : values) {
            if(sw.code == code) {
                return sw;
            }
        }

        return null;
    }

}