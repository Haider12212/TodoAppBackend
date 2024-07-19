package com.Todoapp.TodoApp.model;

import com.Todoapp.TodoApp.util.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("todos")

public class Todos {
    @Id
    private String _id;

    private String userId;

    private String type;

    private String title;

    private String description;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date time;

}
