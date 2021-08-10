package com.dpanda.stickynotes.controller;

import com.dpanda.stickynotes.model.User;
import com.dpanda.stickynotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
