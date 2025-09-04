package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Department;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * 查询所有部门数据
     */
    @GetMapping("/departments")
    public Result getDepartments(){
        try{
            List<Department> list = departmentService.getDepartments();
            return Result.success(list);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
