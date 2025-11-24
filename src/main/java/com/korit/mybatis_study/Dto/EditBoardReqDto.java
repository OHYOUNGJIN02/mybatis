package com.korit.mybatis_study.Dto;

import com.korit.mybatis_study.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class EditBoardReqDto {
    private Integer boardId;
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .title(title)
                .content(content)
                .build();
    }
}
