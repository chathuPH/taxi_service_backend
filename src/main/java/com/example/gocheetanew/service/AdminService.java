package com.example.gocheetanew.service;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Admin;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.repository.AdminRepository;
import com.example.gocheetanew.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService implements UserService{

    private AdminRepository adminRepository;

    @Override
    public Admin login(String username, String password){

        Admin response = adminRepository.findByUsername(username);
        if(response == null){
            throw  new RuntimeException("admin not found");
        }else{
            if(response.getPassword().equals(password)){
                return response;
            }else{
                return null;
            }
        }
    }

    @Override
    public Admin register(RegisterDto registerDto){

        if(registerDto == null){
            throw  new RuntimeException("null or field missing");
        }
        Admin admin = new Admin();
        admin.setUsername(registerDto.getUsername());
        admin.setPassword(registerDto.getPassword());

        return adminRepository.save(admin);

    }

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

    public Admin findById(long id){
        return adminRepository.findById(id).orElseThrow(()-> new RuntimeException("admin not found"));
    }
}
