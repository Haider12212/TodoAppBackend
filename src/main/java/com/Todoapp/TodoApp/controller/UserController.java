package com.Todoapp.TodoApp.controller;

import com.Todoapp.TodoApp.model.Users;
import com.Todoapp.TodoApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{name}")
    public String greet(@PathVariable String name){
        return ("Hello " + name + "! I hope you are having a blast on your first official day...");
    }
    @GetMapping("allUsers")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

   @PostMapping("Login")
    public ResponseEntity<Map<String, Object>> signIn(@RequestBody Users user){
        String email = user.getEmail();
        String password = user.getPassword();
       System.out.println("Email is " + email + " password is " + password);
       System.out.println("This is the second log"+ Objects.requireNonNull(userService.verifyUser(email, password).getBody()).toString());
        return userService.verifyUser(email,password);
   }

   @PostMapping("Register")
    public String register(@RequestBody Users user){
       return userService.addUser(user);
   }
}
