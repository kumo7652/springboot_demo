package com.example.springboot_demo.controller;

import com.example.springboot_demo.pojo.Department;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * 查询所有部门数据
     */
    @GetMapping
    public Result getDepartments(){
        try{
            List<Department> list = departmentService.getDepartments();
            return Result.success(list);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Result getDepartmentById(@PathVariable Integer id){
        try{
            Department department = departmentService.getDepartmentById(id);
            return Result.success(department);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除部门信息
     */
    @DeleteMapping
    public Result deleteDepartments(@RequestParam Integer id){
        try {
            departmentService.deleteDepartment(id);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    /**
     * 添加部门信息
     */
    @PostMapping
    public Result addDepartment(@RequestBody Department department){
        try {
            departmentService.addDepartment(department);
            return Result.success();
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
