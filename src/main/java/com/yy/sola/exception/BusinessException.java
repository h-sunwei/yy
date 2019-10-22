package com.yy.sola.exception;

import lombok.Data;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 11:34
 * @description: 业务异常
 */
@Data
public class BusinessException extends RuntimeException {

    private CustomExceptionEnum customExceptionEnum;

    private int code;

    private String msg;

    public BusinessException (CustomExceptionEnum customExceptionEnum) {
        this.customExceptionEnum = customExceptionEnum;
    }

    public BusinessException (int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
