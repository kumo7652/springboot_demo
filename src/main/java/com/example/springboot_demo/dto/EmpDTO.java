package com.example.springboot_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
    private String name;
    private Short gender;
    private LocalDate start;
    private LocalDate end;
    private Integer page = 1;
    private Integer pageSize = 5;
}
