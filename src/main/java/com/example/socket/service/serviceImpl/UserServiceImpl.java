package com.example.socket.service.serviceImpl;

import com.example.socket.entity.User;
import com.example.socket.repository.UserRepository;
import com.example.socket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User update(Integer id, User user) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
