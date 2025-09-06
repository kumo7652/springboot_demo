package com.example.springboot_demo.service;

import com.example.springboot_demo.dto.EmpDTO;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;


public interface EmployeeService {
    /**
     * 分页查询所有员工数据
     */
    PageResult<Employee> page(EmpDTO empDTO);
}
