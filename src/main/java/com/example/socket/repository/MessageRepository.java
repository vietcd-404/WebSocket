package com.example.socket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socket.entity.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
//    List<Message> findAllByOrderByCreatedAtDesc();
}
