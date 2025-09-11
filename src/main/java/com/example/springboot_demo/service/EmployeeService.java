package com.example.springboot_demo.service;

import com.example.springboot_demo.dto.EmpQueryDTO;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;

import java.util.List;


public interface EmployeeService {
    /**
     * 分页查询所有员工数据
     */
    PageResult<Employee> page(EmpQueryDTO empQueryDTO);

    /**
     * 添加员工信息与员工工作经历信息
     */
    void addEmployee(Employee employee);

    /**
     * 批量删除员工信息与对应的工作经历信息
     */
    void deleteEmployees(List<Integer> ids);

    /**
     * 通过id查询员工信息与对应的工作经历信息
     */
    Employee getEmployeeById(Integer id);

    /**
     * 更新员工信息与工作经历信息
     */
    void updateEmployee(Employee employee);
}
