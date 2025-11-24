package com.korit.mybatis_study.Repository;

import com.korit.mybatis_study.Entity.Todo;
import com.korit.mybatis_study.Mapper.BoardMapper;
import com.korit.mybatis_study.Mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class TodoRepository {

    @Autowired
    private TodoMapper todoMapper;
    @Autowired
    private BoardMapper boardMapper;

    public Optional<Todo> findByTitle(String title){
        return todoMapper.findByTitle(title);

    }
    public Optional<Todo> addTodo(Todo todo) {
        try {
            todoMapper.addTodo(todo);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(todo);

}

    public List<Todo> getTodoList(){
        return todoMapper.getTodoList();
    }

    public Optional<Todo> findTodoByTodoId(Integer todoId){
        return todoMapper.findTodoByTodoId(todoId);
    }

    public int editTodo(Todo todo){
        return todoMapper.editTodo(todo);
    }

    public int removeTodo(Integer todoId){
        return todoMapper.removeTodo(todoId);
    }

}
