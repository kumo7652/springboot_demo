package com.example.springboot_demo.mapper;

import com.example.springboot_demo.dto.ClazzQueryDto;
import com.example.springboot_demo.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 条件分页查询所有班级数据
     */
    List<Clazz> getClazz(ClazzQueryDto d);

    /**
     * 根据id删除课程信息
     */
    void deleteClazz(Integer id);
}
