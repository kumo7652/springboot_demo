package com.example.springboot_demo.controller;

import com.example.springboot_demo.dto.ClazzQueryDto;
import com.example.springboot_demo.pojo.Clazz;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.ClazzService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clazz")
public class ClazzController {
    private final ClazzService clazzService;

    @GetMapping
    public Result getClazz(@RequestBody ClazzQueryDto d){
        log.info("查询所有班级信息");

        PageResult<Clazz> p = clazzService.page(d);
        return Result.success(p);
    }

    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id){
        log.info("删除id为{}的班级", id);

        clazzService.deleteClazz(id);
        return Result.success();
    }
    
}
