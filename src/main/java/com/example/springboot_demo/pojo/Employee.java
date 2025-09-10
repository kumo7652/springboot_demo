package com.example.springboot_demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;                     // 员工id
    private String username;                // 用户名
    private String password;                // 密码
    private Short gender;                   // 性别
    private String phone;                   // 手机号
    private Short job;                      // 职位
    private Double salary;                  // 薪资
    private LocalDate entryDate;            // 入职日期
    private LocalDateTime createTime;       // 创建时期
    private LocalDateTime updateTime;       // 修改时期
    private String image;                   // 头像
    private Integer deptId;                 // 所属部门id

    // 用于封装部门名称属性
    private String deptName;
    private List<EmpExpr> exprList;         // 工作经历信息
}
