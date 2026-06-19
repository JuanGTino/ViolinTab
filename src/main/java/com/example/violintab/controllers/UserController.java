package com.example.violintab.controllers;

import com.example.violintab.models.User;
import com.example.violintab.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // Ruta base de la API
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET http://localhost:8080/api/usuarios
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

}
