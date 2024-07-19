package com.Todoapp.TodoApp.service;

import com.Todoapp.TodoApp.dao.TodosDao;
import com.Todoapp.TodoApp.model.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {
    @Autowired
    TodosDao todosDao;
    public List<Todos> getAllTodos(){
        return todosDao.findAll();
    }

    public String addTodos(Todos todos){
        try{
            todosDao.save(todos);
            return "Todos added Successfully";
        }catch (Exception e){
            return e.toString();
        }
    }

    public List<Todos> getTodosById(String userId) {
        return todosDao.findByuserId(userId);
    }

    public String updateTodo(String id) {
        try {
            Todos todos = todosDao.getBy_id(id);
            todos.set_id(id);
            return "Todo Updated Successfully";
        } catch (Exception e) {
            return e.toString();

        }

    }
}
