package com.example.springboot_demo.service.impl;

import com.example.springboot_demo.mapper.StudentMapper;
import com.example.springboot_demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentMapper studentMapper;


}
