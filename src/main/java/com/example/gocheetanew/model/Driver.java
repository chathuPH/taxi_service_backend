package com.example.gocheetanew.model;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.service.DriverService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Driver")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Driver implements User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "driver_name")
    private String driverName;

    @OneToOne
    @JoinColumn(name = "branch")
    private Branch branch;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Transient
    @JsonIgnore
    DriverService driverService;
//
//    @Override
//    public Driver login(String username, String password) {
//        return driverService.login(username, password);
//    }
//
//    @Override
//    public User register(RegisterDto registerDto) {
//        return driverService.register(registerDto);
//    }

}