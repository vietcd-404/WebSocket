package com.example.socket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "message")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    private Date creatAt = new Date();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
