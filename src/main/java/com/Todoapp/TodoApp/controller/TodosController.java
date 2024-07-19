package com.Todoapp.TodoApp.controller;

import com.Todoapp.TodoApp.model.Todos;
import com.Todoapp.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api")
public class TodosController {
    @Autowired
    TodoService todoService;

    @GetMapping("allTodos")
    public List<Todos> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping("addTodos")
    public String addTodos(@RequestBody Todos todos){
        return todoService.addTodos(todos);
    }

    @GetMapping("/todos/{userId}")
    public List<Todos> getTodosById(@PathVariable String userId){
        return todoService.getTodosById(userId);
    }

    @Async
    @PutMapping("/todos/{todoId}")
    public String updateTodo(@PathVariable String todoId){
        try {
            return todoService.updateTodo(todoId);
        }catch (Exception e){
            return e.toString();
        }

    }

    @Async
    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable String todoId){
        try{
            return todoService.deleteTodo(todoId);
        }catch (Exception e){
            return e.toString();
        }
    }

}
