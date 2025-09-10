package com.example.springboot_demo.mapper;

import com.example.springboot_demo.dto.EmpQueryDTO;
import com.example.springboot_demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    /**
     * 分页查询所有员工数据
     */
    List<Employee> getEmployees(EmpQueryDTO empQueryDTO);

    void addEmployee(Employee employee);
}
