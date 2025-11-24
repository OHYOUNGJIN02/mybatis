package com.korit.mybatis_study.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ApiDataRespDto <T>{
    private String status;
    private String message;
    private T data;
}
