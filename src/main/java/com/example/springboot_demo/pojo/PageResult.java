package com.example.springboot_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {
    private Long total;         // 总记录数
    private List<T> rows;       // 所有记录
}
