package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.VehicleDto;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Vehicle;
import com.example.gocheetanew.service.BranchService;
import com.example.gocheetanew.service.CategoryService;
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
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private VehicleService vehicleService;
    private CategoryService categoryService;
    private DriverService driverService;
    private BranchService branchService;

    @PostMapping("/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDto vehicleDto){

        Vehicle vehicle = new Vehicle();
        HttpStatus response = HttpStatus.CREATED;

        if(vehicleDto == null){
            response =  HttpStatus.BAD_REQUEST;
        }


        vehicle.setCategory(categoryService.findById(vehicleDto.getCategory()));
        vehicle.setVehicleName(vehicleDto.getVehicleName());
        vehicle.setNumberPlate(vehicleDto.getNumberPlate());
        vehicle.setStatus("free");
        vehicle.setBranch(branchService.findById(vehicleDto.getBranch()));
        vehicle.setDriver(driverService.findById(vehicleDto.getDriver()));

        return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody VehicleDto vehicleDto){

        Vehicle vehicle = vehicleService.findById(vehicleDto.getId());
        HttpStatus response = HttpStatus.CREATED;

        if(vehicleDto == null){
            response =  HttpStatus.BAD_REQUEST;
        }

        vehicle.setCategory(categoryService.findById(vehicleDto.getCategory()));
        vehicle.setVehicleName(vehicleDto.getVehicleName());
        vehicle.setNumberPlate(vehicleDto.getNumberPlate());
        vehicle.setStatus(vehicleDto.getStatus());
        vehicle.setBranch(branchService.findById(vehicleDto.getBranch()));
        vehicle.setDriver(driverService.findById(vehicleDto.getDriver()));

        return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Vehicle>>  findAll(){
        return new ResponseEntity<>( vehicleService.findAll(), HttpStatus.ACCEPTED);
    }


    @PostMapping("/findAllByTypeAndStatus")
    public ResponseEntity<List<Vehicle>> findAllByTypeAndStatus(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.findAllByTypeAndStatus(vehicleDto.getCategory(),vehicleDto.getStatus()),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Vehicle> delete(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(vehicleService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/findByDriver")
    public ResponseEntity<List<Vehicle>> getVehicleByDriverId(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(vehicleService.findByDriver(Long.parseLong(id)),HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Vehicle> findById(@RequestParam(name = "id") String id){
        return new ResponseEntity<>(vehicleService.findById(Long.parseLong(id)),HttpStatus.OK);
    }
}
