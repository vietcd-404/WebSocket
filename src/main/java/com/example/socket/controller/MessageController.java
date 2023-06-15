package com.example.socket.controller;

import com.example.socket.entity.Message;
import com.example.socket.service.serviceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<Message> getList(){
        return messageService.getList();
    }

    @PostMapping
    public void createMessage(@RequestBody Message message) {
        // Lưu tin nhắn vào cơ sở dữ liệu
        messageService.insert(message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
