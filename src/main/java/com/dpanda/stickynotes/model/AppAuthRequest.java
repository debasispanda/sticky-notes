package com.dpanda.stickynotes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AppAuthRequest {
    private String username;
    private String password;
}
