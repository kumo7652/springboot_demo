package com.example.springboot_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer ID;                     // 部门ID
    private String name;                    // 部门名称
    private LocalDateTime createTime;       // 创建时期
    private LocalDateTime updateTime;       // 修改时期
}
