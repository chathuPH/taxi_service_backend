package com.example.gocheetanew.model;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer implements User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    @JsonIgnore
    CustomerService customerService;
//
//    @Override
//    public Customer login(String username, String password) {
//        return customerService.login(username,password);
//    }
//
//    @Override
//    public User register(RegisterDto registerDto) {
//        return customerService.register(registerDto);
//    }
}
