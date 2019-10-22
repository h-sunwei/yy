package com.yy.sola.exception;

import com.yy.sola.exception.BusinessException;
import com.yy.sola.support.CustomResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 13:13
 * @description: 全局异常处理站
 */
@ControllerAdvice
@ResponseBody
public class WebExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public CustomResponse handleException (BusinessException e) {
        CustomResponse customResponse = new CustomResponse();
        int code = e.getCustomExceptionEnum().getCode();
        String message = e.getCustomExceptionEnum().getDesc();
        customResponse.setCode(code);
        customResponse.setMessage(message);
        return customResponse;
    }

    @ExceptionHandler(Exception.class)
    public CustomResponse handleExceptions (Exception e) {
        e.printStackTrace();
        CustomResponse customResponse = new CustomResponse();
        customResponse.setCode(999);
        customResponse.setMessage("未知异常");
        return customResponse;
    }
}
