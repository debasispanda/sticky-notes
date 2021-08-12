package com.dpanda.stickynotes.service;

import com.dpanda.stickynotes.model.AppUser;
import com.dpanda.stickynotes.model.AppUserRequest;
import com.dpanda.stickynotes.model.AppUserRole;
import com.dpanda.stickynotes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByUserName(userName);
    }

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    public void createUser(AppUserRequest user) {
        AppUser existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalStateException("User already registered!");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        AppUser newUser = new AppUser(
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getDob(),
                user.getEmail(),
                encodedPassword,
                user.getIsAdmin() ? AppUserRole.ADMIN : AppUserRole.USER,
                new Date()
        );
        userRepository.save(newUser);
    }
}
