package com.example.springboot_demo.exception;

import com.example.springboot_demo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler { // 全局异常处理器

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错：",e);
        return Result.error(e.getMessage());
    }
}
