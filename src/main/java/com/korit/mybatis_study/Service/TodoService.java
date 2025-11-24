package com.korit.mybatis_study.Service;

import com.korit.mybatis_study.Dto.AddTodoReqDto;
import com.korit.mybatis_study.Dto.ApiDataRespDto;
import com.korit.mybatis_study.Dto.ApiRespDto;
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
        Optional<Todo> foundUsername = todoRepository.findByTitle(addTodoReqDto.getTitle());
        if (foundUsername.isPresent()){
            return new ApiRespDto("failed", "유저 네임이 중복되었습니다", null);

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
    public ApiRespDto<?>editTodo(Integer todoId){
        Optional<Todo> foundTodo = todoRepository.findTodoByTodoId(todoId);
        if (foundTodo.isEmpty()){
            return new ApiRespDto<>("failed", "수정 실패",  null);
        }
    }
}
