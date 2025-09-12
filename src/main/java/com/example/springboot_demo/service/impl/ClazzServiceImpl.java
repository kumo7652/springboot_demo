package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.dto.ClazzQueryDto;
import com.example.springboot_demo.mapper.ClazzMapper;
import com.example.springboot_demo.mapper.StudentMapper;
import com.example.springboot_demo.pojo.Clazz;
import com.example.springboot_demo.pojo.PageResult;
import com.example.springboot_demo.service.ClazzService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ClazzServiceImpl implements ClazzService {
    private final ClazzMapper clazzMapper;
    private final StudentMapper studentMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryDto d) {
        // 设置分页参数
        PageHelper.startPage(d.getPage(), d.getPageSize());

        // 查询数据
        Page<Clazz> p = (Page<Clazz>) clazzMapper.getClazz(d);

        // 设置课程状态
        LocalDate now = LocalDate.now();

        for (Clazz clazz : p) {
            if (clazz.getBeginDate() == null || clazz.getEndDate() == null) {
                clazz.setStatus("日期未设置");
                continue;
            }

            if (clazz.getBeginDate().isAfter(now)) {
                clazz.setStatus("未开课");
            } else if (clazz.getEndDate().isBefore(now)) {
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("已开课");
            }
        }

        // 返回结果
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteClazz(Integer id) {
        // 查询该班级中是否有学生
        if (studentMapper.getStudentInClazz(id) != 0)
            throw new IllegalArgumentException("班级下有学院，不能直接删除~");

        clazzMapper.deleteClazz(id);
    }

    @Override
    public void insertClazz(Clazz clazz) {
        if (clazz.getName() == null) throw new IllegalArgumentException("班级为空，无法添加~");
        clazzMapper.insertClazz(clazz);
    }
}
