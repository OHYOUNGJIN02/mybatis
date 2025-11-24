package com.korit.mybatis_study.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ApiRespDto <T>{
    private String status;
    private String message;
    private T data;
}
