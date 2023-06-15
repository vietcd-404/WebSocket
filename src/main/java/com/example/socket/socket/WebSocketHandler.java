package com.example.socket.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler implements WebSocketConfigurer {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new ChatWebSocketHandler(), "/ws")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    private class ChatWebSocketHandler extends TextWebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) {
            sessions.add(session);
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            String payload = message.getPayload();
            // Xử lý tin nhắn từ người dùng và gửi lại cho tất cả các người dùng khác
            messagingTemplate.convertAndSend("/topic/messages", payload);
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
            sessions.remove(session);
        }
    }
}

