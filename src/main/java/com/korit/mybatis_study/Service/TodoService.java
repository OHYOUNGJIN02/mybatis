package com.korit.mybatis_study.Service;

import com.korit.mybatis_study.Dto.AddTodoReqDto;
import com.korit.mybatis_study.Dto.ApiDataRespDto;
import com.korit.mybatis_study.Dto.ApiRespDto;
import com.korit.mybatis_study.Dto.EditTodoReqDto;
import com.korit.mybatis_study.Entity.Board;
import com.korit.mybatis_study.Entity.Todo;
import com.korit.mybatis_study.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public ApiRespDto addTodo(AddTodoReqDto addTodoReqDto) {
        Optional<Todo> foundTodo = todoRepository.findByTitle(addTodoReqDto.getTitle());
        if (foundTodo.isPresent()){
            return new ApiRespDto("failed", "제목이 중복되었습니다", null);

        }
        Optional<Todo> todo = todoRepository.addTodo(addTodoReqDto.toEntity());
        if (todo.isEmpty()){
            return new ApiRespDto("failed", "추가하는 데에 문제가 생겼습니다", null);
        }
        return new ApiRespDto("success", "추가 성공", todo.get());
    }
    public ApiRespDto getTodoList(){
        return new ApiRespDto<>("success", "todo 목록", todoRepository.getTodoList());
    }

    public ApiRespDto<?>findTodoByTodoId(Integer todoId){
        Optional<Todo> foundTodo = todoRepository.findTodoByTodoId(todoId);
        if (foundTodo.isEmpty()){
            return new ApiRespDto<>("failed", "없습니다", null);
        }
        return new ApiRespDto<>("success", "조회 완료", foundTodo.get());
    }
    public ApiRespDto<?>editTodo(EditTodoReqDto editTodoReqDto) {
        Optional<Todo> foundTodo = todoRepository.findTodoByTodoId(editTodoReqDto.getTodoId());
        if (foundTodo.isEmpty()){
            return new ApiRespDto<>("failed", "실패",  null);
        }
        int result = todoRepository.editTodo(editTodoReqDto.toEntity());
        if (result != 1) {
            return new ApiRespDto<>("failed", "수정하는데 문제가 발생했습니다.", null);
        }
        return new ApiRespDto<>("success", "수정 성공", null);
    }
    public ApiRespDto<?> removeTodo(Integer todoId) {
        Optional<Todo> foundTodo = todoRepository.findTodoByTodoId(todoId);
        if (foundTodo.isEmpty()) {
            return new ApiRespDto<>("failed", "해당 존재하지 않습니다.", null);
        }
        int result = todoRepository.removeTodo(foundTodo.get().getTodoId());
        if (result != 1) {
            return new ApiRespDto<>("failed", "삭제하는데 문제가 발생했습니다.", null);
        }
        return new ApiRespDto<>("success", "삭제되었습니다.", null);
    }

    }
