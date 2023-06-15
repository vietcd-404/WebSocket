package com.example.socket.service.serviceImpl;

import com.example.socket.entity.Message;
import com.example.socket.repository.MessageRepository;
import com.example.socket.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getList() {
        return messageRepository.findAll();
    }

    @Override
    public Message insert(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Message update(Integer id, Message message) {
        return null;
    }

    @Override
    public Message findById(int id) {
        return null;
    }
}
