package com.yy.sola.support;

import lombok.Data;

/**
 * @author: sunwei
 * @date: 2019-09-11
 * @time: 12:55
 * @description:  统一返回数据接口
 */
@Data
public class CustomResponse {

    private int code;

    private String message;

    private Object data;

    /**
     * 请求成功（无参数值）
     * @return
     */
    public static CustomResponse ok () {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setCode(200);
        customResponse.setMessage("请求成功");
        return customResponse;
    }

    /**
     * 请求成功（有参数值）
     * @param data
     * @return
     */
    public static CustomResponse ok (Object data) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setCode(200);
        customResponse.setMessage("请求成功");
        customResponse.setData(data);
        return customResponse;
    }


}
