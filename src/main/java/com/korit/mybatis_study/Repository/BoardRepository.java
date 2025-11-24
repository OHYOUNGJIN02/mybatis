package com.korit.mybatis_study.Repository;

import com.korit.mybatis_study.Entity.Board;
import com.korit.mybatis_study.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardRepository {

    @Autowired
    private BoardMapper  boardMapper;

    public Optional<Board> findBoardByTitle(String title){
        return boardMapper.findBoardByTitle(title);
    }

    public Optional<Board> addBoard(Board board) {
        try {
            boardMapper.addBoard(board);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(board);
    }

    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }

    public Optional<Board> getBoardByBoardId(Integer boardId) {
        return boardMapper.findBoardByBoardID(boardId);
    }

    public int editBoard(Board board) {
        return boardMapper.editBoard(board);
    }

    public int removeBoard(Integer boardId) {
        return boardMapper.removeBoard(boardId);
    }
}
