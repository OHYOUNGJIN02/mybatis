package com.korit.mybatis_study.Mapper;

import com.korit.mybatis_study.Entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper

public interface TodoMapper {
    Optional<Todo> findByTitle(String title);
    int addTodo(Todo todo);
    List<Todo> getTodoList();
    Optional<Todo> findTodoByTodoId(Integer todoId);
    int editTodo(Todo todo);
    int removeTodo(Integer todoId);

}
