package com.Todoapp.TodoApp.service;

import com.Todoapp.TodoApp.dao.UserDao;
import com.Todoapp.TodoApp.model.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    private static final String SECRET_KEY = "your_secret_key_here";
    public static String generateToken(String userId) {
        return Jwts.builder()
                .claim("userId", userId)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }

    public ResponseEntity<Map<String, Object>> verifyUser(String email, String password) {
        try {
            Users user = userDao.findByEmail(email);
            if (user != null && password.equals(user.getPassword())) {
                String userId = user.getId();
                String token = generateToken(userId);
                Map<String, Object> response = new HashMap<>();
                response.put("token", token);
                response.put("userId", userId);
                System.out.println(response.toString());
                return ResponseEntity.ok(response);
            } else {
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Invalid email or password");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Internal server error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public String addUser(Users user) {
        if (!userDao.existsByEmail(user.getEmail())) {
            userDao.save(user);
            return "User Registered Successfully";
        } else {
            return "User with this email already exists";
        }
    }



    public List<Users> getAllUsers(){
        return userDao.findAll();
    }
}
