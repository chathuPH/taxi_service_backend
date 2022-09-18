package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.LoginDto;
import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.User;
import com.example.gocheetanew.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if(loginDto==null){
            throw new RuntimeException("username pr password cannot be null");
        }
        User user = authService.login(loginDto.getType(), loginDto.getUsername(), loginDto.getPassword());
        if(user== null){
            status= HttpStatus.BAD_REQUEST;
        }else{
            status= HttpStatus.ACCEPTED;
        }
        return  new ResponseEntity<>(user, status);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto){
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if(registerDto==null){
            throw new RuntimeException("bad request");
        }
        User user = authService.register(registerDto);
        if(user== null){
            status= HttpStatus.BAD_REQUEST;
        }else{
            status= HttpStatus.ACCEPTED;
        }
        return  new ResponseEntity<>(user, status);
    }
}
