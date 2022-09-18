package com.example.gocheetanew.service;

import com.example.gocheetanew.model.Admin;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.model.User;
import com.example.gocheetanew.repository.AdminRepository;
import com.example.gocheetanew.repository.CustomerRepository;
import com.example.gocheetanew.repository.DriverRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class Factory {



    public User generate(String type){

        switch (type){
            case ("driver"):
                return new Driver();
            case ("admin"):
                return new Admin();
            case ("customer"):
                return new Customer();
            default:
                return null;
        }
    }
}
