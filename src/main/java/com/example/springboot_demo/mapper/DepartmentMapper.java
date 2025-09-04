package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    /**
     * 查询所有部门信息
     * 根据最后修改时间降序排序
     */
    List<Department> getDepartments();

    /**
     * 删除部门信息
     */
    void deleteDepartmentById(Integer id);
}
