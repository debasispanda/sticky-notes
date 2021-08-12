package com.dpanda.stickynotes.controller;

import com.dpanda.stickynotes.model.AppUser;
import com.dpanda.stickynotes.model.AppUserRequest;
import com.dpanda.stickynotes.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserController {
    private final AppUserService appUserService;

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserService.getAll();
    }

    @PostMapping(path = "/register")
    public void registerUser(@RequestBody AppUserRequest user) {
        appUserService.createUser(user);
    }
}
