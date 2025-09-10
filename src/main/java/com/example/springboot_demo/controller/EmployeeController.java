package com.example.springboot_demo.controller;

import com.example.springboot_demo.dto.EmpQueryDTO;
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

    /**
     * 条件分页查询所有员工信息
     */
    @GetMapping
    public Result getEmployees(@RequestBody EmpQueryDTO empQueryDTO) {
        log.info("查询员工信息");
        try {
            PageResult<Employee> pages = employeeService.page(empQueryDTO);
            return Result.success(pages);
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 添加员工信息
     */
    @PostMapping
    public Result addEmployee(@RequestBody Employee employee) {
        log.info("新增员工: {}", employee);
        
        try {
            employeeService.addEmployee(employee);
            return Result.success();
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }
}
