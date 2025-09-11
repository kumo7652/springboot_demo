package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.dto.EmpQueryDTO;
import com.example.springboot_demo.mapper.EmpExprMapper;
import com.example.springboot_demo.mapper.EmployeeMapper;
import com.example.springboot_demo.pojo.EmpExpr;
import com.example.springboot_demo.pojo.Employee;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmpExprMapper empExprMapper;

    @Override
    public PageResult<Employee> page(EmpQueryDTO empQueryDTO) {
        // 1. 设置分页参数
        PageHelper.startPage(empQueryDTO.getPage(), empQueryDTO.getPageSize());

        // 2. 查询，解析并封装结果
        Page<Employee> p = (Page<Employee>) employeeMapper.getEmployees(empQueryDTO);

        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addEmployee(Employee e) {
        // 1. 补全基本信息
        e.setCreateTime(LocalDateTime.now());
        e.setUpdateTime(LocalDateTime.now());

        // 2. 添加员工信息
        employeeMapper.addEmployee(e);

        // 3. 添加工作经历信息
        List<EmpExpr> exprList = e.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            // 为工作经历信息绑定员工id
            for (EmpExpr expr : exprList) {
                expr.setEmpId(e.getId());
            }

            empExprMapper.insertEmpExpr(exprList);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteEmployees(List<Integer> ids) {
        employeeMapper.deleteEmployees(ids);
        empExprMapper.deleteEmpExpr(ids);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployee(Employee e) {
        // 1.更新员工基本信息
        employeeMapper.updateEmployee(e);

        // 2.更新员工工作经历信息-先清空，再添加
        List<EmpExpr> exprList = e.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            empExprMapper.deleteEmpExpr(Collections.singletonList(e.getId()));

            for (EmpExpr expr : exprList) {
                expr.setEmpId(e.getId());
                empExprMapper.insertEmpExpr(exprList);
            }
        }
    }
}
