package com.example.springboot_demo.pojo;

import lombok.Data;

/**
 * 前后端交互统一返回结果
 */
@Data
public class Result {
    private int code;       // 状态码，1为成功，0为失败
    private String msg;     // 错误信息
    private Object data;    // 数据

    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.data = data;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
