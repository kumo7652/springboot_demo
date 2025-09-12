package com.example.springboot_demo.service;

import com.example.springboot_demo.dto.ClazzQueryDto;
import com.example.springboot_demo.pojo.Clazz;
import com.example.springboot_demo.pojo.PageResult;

public interface ClazzService {
    /**
     * 条件分页查询所有班级数据
     */
    PageResult<Clazz> page(ClazzQueryDto d);

    void deleteClazz(Integer id);
}
