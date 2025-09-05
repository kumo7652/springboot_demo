package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.DepartmentMapper;
import com.example.springboot_demo.pojo.Department;
import com.example.springboot_demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentMapper.deleteDepartmentById(id);
    }

    @Override
    public void addDepartment(Department department) {
        // 填充基本属性
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());

        departmentMapper.addDepartment(department);
    }

    @Override
    public Department getDepartmentById(Integer id){
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public void updateDepartment(Department department) {
        department.setUpdateTime(LocalDateTime.now());

        departmentMapper.updateDepartment(department);
    }
}
