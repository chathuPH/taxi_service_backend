package com.example.gocheetanew.model;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.repository.AdminRepository;
import com.example.gocheetanew.service.AdminService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin implements User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username",  unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    @JsonIgnore
    private AdminService adminService;

//    @Override
//    public Admin login(String username, String password) {
//
//
//        return adminService.login(username,password);
//    }
//
//    @Override
//    public User register(RegisterDto registerDto) {
//
//        return adminService.register(registerDto);
//    }
}
