package com.dpanda.stickynotes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Date dob;
    private Boolean isAdmin;
}
