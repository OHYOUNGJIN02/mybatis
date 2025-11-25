package com.korit.mybatis_study.Controller;

import com.korit.mybatis_study.Dto.AddTodoReqDto;
import com.korit.mybatis_study.Dto.EditTodoReqDto;
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
    public ResponseEntity<?> findTodoByTodoId(@PathVariable Integer todoId){
        return ResponseEntity.ok(todoService.findTodoByTodoId(todoId));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> updateTodo(@RequestBody EditTodoReqDto editTodoReqDto){
        return ResponseEntity.ok(todoService.editTodo(editTodoReqDto));
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeTodo(@RequestParam Integer todoId){
        return ResponseEntity.ok(todoService.removeTodo(todoId));
    }
    //12321


}
