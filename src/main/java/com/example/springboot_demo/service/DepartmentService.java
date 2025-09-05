package com.example.springboot_demo.service;

import com.example.springboot_demo.pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();

    void deleteDepartment(Integer id);

    void addDepartment(Department department);

    Department getDepartmentById(Integer id);

    void updateDepartment(Department department);
}
