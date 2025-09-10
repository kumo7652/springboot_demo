package com.example.springboot_demo.service;

import com.example.springboot_demo.dto.EmpQueryDTO;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;


public interface EmployeeService {
    /**
     * 分页查询所有员工数据
     */
    PageResult<Employee> page(EmpQueryDTO empQueryDTO);

    void addEmployee(Employee employee);
}
