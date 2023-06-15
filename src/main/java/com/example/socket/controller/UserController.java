package com.example.socket.controller;

import com.example.socket.entity.User;
import com.example.socket.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getList(){
        return userService.getList();
    }
}
