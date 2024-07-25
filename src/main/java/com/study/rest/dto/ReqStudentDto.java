package com.study.rest.dto;

import lombok.Data;

// 데이터의 값을 가져가서 찍어주려면 ToString 필요
@Data
public class ReqStudentDto {
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
