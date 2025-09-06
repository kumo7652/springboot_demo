package com.example.springboot_demo.controller;

import com.example.springboot_demo.dto.EmpDTO;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Result getEmployees(@RequestBody EmpDTO empDTO)
    {
        try {
            PageResult<Employee> pages = employeeService.page(empDTO);
            return Result.success(pages);
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
