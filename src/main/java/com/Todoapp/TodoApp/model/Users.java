package com.Todoapp.TodoApp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
@Data
public class Users {
    @Id
    private String id;

    private String email;

    private String password;
}
