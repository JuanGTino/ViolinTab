package com.example.violintab.services;

import org.springframework.stereotype.Service;
import com.example.violintab.repositories.UserRepository;
import com.example.violintab.models.User;

import java.util.List;

@Service
public class UserService {
    private final   UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
