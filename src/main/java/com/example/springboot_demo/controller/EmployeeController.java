package com.example.springboot_demo.controller;

import com.example.springboot_demo.dto.EmpQueryDTO;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
     * 通过id查询员工信息与工作经历信息
     */
    @GetMapping("/{id}")
    public Result getEmployee(@PathVariable Integer id) {
        log.info("查询id为{}的员工", id);

        try{
            Employee employee = employeeService.getEmployeeById(id);
            return Result.success(employee);
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

    /**
     * 删除员工信息
     */
    @DeleteMapping
    public Result deleteEmployees(@RequestParam List<Integer> ids) {
        log.info("删除id为{}的员工", ids.toString());

        try{
            employeeService.deleteEmployees(ids);
            return Result.success();
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    @PutMapping
    public Result updateEmployee(@RequestBody Employee employee) {
        log.info("更新员工{}", employee);

        try{
            employeeService.updateEmployee(employee);
            return Result.success();
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.error(e.getMessage());
        }
    }
}
