package com.example.socket.service;

import com.example.socket.entity.Message;
import com.example.socket.entity.User;

import java.util.List;

public interface MessageService {
    List<Message> getList();

    Message insert(Message message);

    boolean delete(int id);

    Message update(Integer id, Message message);

    Message findById(int id);
}
