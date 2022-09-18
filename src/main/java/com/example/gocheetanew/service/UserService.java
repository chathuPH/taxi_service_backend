package com.example.gocheetanew.service;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.User;

public interface UserService {

    User login(String username, String password);
    User register(RegisterDto registerDto);
}
