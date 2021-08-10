package com.dpanda.stickynotes.repository;

import com.dpanda.stickynotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
