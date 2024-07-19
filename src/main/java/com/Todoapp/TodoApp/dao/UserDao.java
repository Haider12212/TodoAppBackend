package com.Todoapp.TodoApp.dao;

import com.Todoapp.TodoApp.model.Users;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<Users, String> {
    Users findByEmail(String email);
    boolean existsByEmail(String email);
}
