package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.dto.EmpDTO;
import com.example.springboot_demo.mapper.EmployeeMapper;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    @Override
    public PageResult<Employee> page(EmpDTO empDTO)
    {
        PageHelper.startPage(empDTO.getPage(), empDTO.getPageSize());

        Page<Employee> p = (Page<Employee>) employeeMapper.getEmployees(empDTO);

        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
