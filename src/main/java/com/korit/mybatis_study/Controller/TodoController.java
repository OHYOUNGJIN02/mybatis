package com.korit.mybatis_study.Controller;

import com.korit.mybatis_study.Dto.AddTodoReqDto;
import com.korit.mybatis_study.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")

public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add1")
    public ResponseEntity<?> addTodo(@RequestBody AddTodoReqDto addTodoReqDto){
        return ResponseEntity.ok(todoService.addTodo(addTodoReqDto));
    }

    @GetMapping("/todolist")
    public ResponseEntity<?> getTodoList(){
        return ResponseEntity.ok(todoService.getTodoList());
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<?> getTodoListByBoardId(@PathVariable Integer todoId){
        return ResponseEntity.ok(todoService.findTodoByTodoId(todoId));
    }


}
