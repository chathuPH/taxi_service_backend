package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.BranchDto;
import com.example.gocheetanew.dto.RegisterDto;
import com.example.gocheetanew.model.Branch;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.service.BranchService;
import com.example.gocheetanew.service.DriverService;
import com.example.gocheetanew.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/driver")
public class DriverController {

    private DriverService driverService;
    private BranchService branchService;
    private VehicleService vehicleService;

    @PutMapping("/update")
    public ResponseEntity<Driver> create(@RequestBody RegisterDto registerDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;

        if(registerDto==null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Driver driver = new Driver();
        driver.setId(registerDto.getDriverId());
        driver.setUsername(registerDto.getUsername());
        driver.setPassword(registerDto.getPassword());
        driver.setDriverName(registerDto.getDriverName());
        driver.setStatus(registerDto.getStatus());
        driver.setBranch(branchService.findById(registerDto.getBranchId()));
        return new ResponseEntity<>(driverService.update(driver),response);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Driver>>  findAll(){
        return new ResponseEntity<>( driverService.findAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Driver> delete(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(driverService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Driver> findById(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(driverService.findById(Long.parseLong(id)),HttpStatus.OK);
    }
}
