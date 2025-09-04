package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.DepartmentMapper;
import com.example.springboot_demo.pojo.Department;
import com.example.springboot_demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    }
}
