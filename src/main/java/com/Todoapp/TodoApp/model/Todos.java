package com.Todoapp.TodoApp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("todos")

public class Todos {
    @Id
    private String id;

    private String userId;

    private String type;

    private String title;

    private String description;

    private Date time;

}
