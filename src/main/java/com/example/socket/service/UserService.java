package com.example.socket.service;

import com.example.socket.entity.User;

import java.util.List;

public interface UserService {
    List<User> getList();

    User insert(User user);

    boolean delete(int id);

    User update(Integer id, User user);

    User findById(int id);
}
