package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    /**
     * 批量添加员工工作经历信息
     */
    void insertEmpExpr(List<EmpExpr> empExpr);

    /**
     * 批量删除员工工作经历信息
     */
    void deleteEmpExpr(List<Integer> empIds);
}
