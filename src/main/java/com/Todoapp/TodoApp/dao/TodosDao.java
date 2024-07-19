package com.Todoapp.TodoApp.dao;

import com.Todoapp.TodoApp.model.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TodosDao extends MongoRepository<Todos, String>{
    List<Todos> findByuserId(String userId);
    Todos getById(String id);
}
