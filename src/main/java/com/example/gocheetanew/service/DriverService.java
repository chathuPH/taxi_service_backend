package com.example.gocheetanew.service;

import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Admin;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.model.User;
import com.example.gocheetanew.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DriverService implements UserService{

    private DriverRepository driverRepository;
    private BranchService branchService;
    private VehicleService vehicleService;

    @Override
    public Driver login(String username, String password){

        Driver response = driverRepository.findByUsername(username);
        if(response == null){
            throw  new RuntimeException("driver not found");
        }else{
            if(response.getPassword().equals(password)){
                return response;
            }else{
                throw  new RuntimeException("wrong password");
            }
        }
    }

    @Override
    public Driver register(RegisterDto registerDto){

        if(registerDto == null){
            throw  new RuntimeException("null or field missing");
        }
        Driver driver = new Driver();
        driver.setUsername(registerDto.getUsername());
        driver.setPassword(registerDto.getPassword());
        driver.setDriverName(registerDto.getDriverName());
        driver.setStatus(registerDto.getStatus());
        driver.setBranch(branchService.findById(registerDto.getBranchId()));

        return driverRepository.save(driver);

    }

    public Driver findById(long id){
        return driverRepository.findById(id).orElseThrow(()-> new RuntimeException("driver not found"));
    }

    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

    public Driver update(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver delete(long id){
        Driver deleted = driverRepository.findById(id).orElseThrow(()->new RuntimeException("driver not found"));
        driverRepository.deleteById(id);
        return deleted;
    }
}
