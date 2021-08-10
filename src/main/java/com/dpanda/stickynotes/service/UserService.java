package com.dpanda.stickynotes.service;

import com.dpanda.stickynotes.model.User;
import com.dpanda.stickynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalStateException("User already registered!");
        }

        User newUser = new User(
                user.getFirstName(),
                user.getLastName(),
                user.getDob(),
                user.getEmail(),
                new Date()
        );
        userRepository.save(newUser);
    }
}
