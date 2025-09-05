package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> getEmployees();
}
