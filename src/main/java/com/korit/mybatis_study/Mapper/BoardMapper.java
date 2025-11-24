package com.korit.mybatis_study.Mapper;

import com.korit.mybatis_study.Entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface BoardMapper {
    Optional<Board> findBoardByTitle(String title);
    int addBoard(Board board);
    List<Board> getBoardList();
    Optional<Board> findBoardByBoardID(Integer boardId);
    int editBoard(Board board);
    int removeBoard(Integer boardId);

}
