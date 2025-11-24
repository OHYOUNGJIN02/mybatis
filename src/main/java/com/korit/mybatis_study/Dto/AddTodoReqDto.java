package com.korit.mybatis_study.Dto;

import com.korit.mybatis_study.Entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AddTodoReqDto {
    private String title;
    private String content;

    public Todo toEntity(){
        return Todo.builder()
                .title(title)
                .content(content)
                .build();
    }
}
