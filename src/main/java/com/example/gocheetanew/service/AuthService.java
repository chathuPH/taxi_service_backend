package com.example.gocheetanew.service;


import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private AdminService adminService;
    private CustomerService customerService;
    private DriverService driverService;

    private Factory factory = new Factory();

    public User login(String type,String username, String password){
        User user  = factory.generate(type);
        if(type.equals("admin")){
            return adminService.login(username,password);
        }else if(type.equals("driver")){
            return driverService.login(username,password);
        }else if(type.equals("customer")){
            return customerService.login(username,password);
        }else{
            return null;
        }
    }

    public User register(RegisterDto registerDto){
        User user = factory.generate(registerDto.getType());
        if(registerDto.getType().equals("admin")){
            return adminService.register(registerDto);
        }else if(registerDto.getType().equals("driver")){
            return driverService.register(registerDto);
        }else if(registerDto.getType().equals("customer")){
            return customerService.register(registerDto);
        }else{
            return null;
        }
    }




}
