package com.mongorest.department.controller;

import java.util.List;

import com.mongorest.department.entity.User;
import com.mongorest.department.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {

        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {

        return ResponseEntity.ok(userRepository.save(user));
    }

}