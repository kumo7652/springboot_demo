package com.example.springboot_demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    Integer getStudentInClazz(Integer cid);
}
