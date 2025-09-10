package com.example.springboot_demo.mapper;

import com.example.springboot_demo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertEmpExpr(List<EmpExpr> empExpr);
}
