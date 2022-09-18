package com.example.gocheetanew.service;

import com.example.gocheetanew.model.Vehicle;
import com.example.gocheetanew.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {

    private VehicleRepository vehicleRepository;

    //save vehicle
    public Vehicle saveVehicle(Vehicle vehicle){return vehicleRepository.save(vehicle);}

    //findAll
    public List<Vehicle> findAll(){return vehicleRepository.findAll();}


    //find all by status and type
    public  List<Vehicle> findAllByTypeAndStatus( long categoryId, String status){
        return vehicleRepository.findAllByCategory_IdAndStatus(categoryId,status);
    }

    //find by id
    public Vehicle findById(long id){ return vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("vehicle not found key"));}

    public List<Vehicle> findByDriver(long id){
        return vehicleRepository.findAllByDriver_Id(id);
    }

    public Vehicle delete(long id){
        Vehicle deleted = vehicleRepository.findById(id).orElseThrow(()->new RuntimeException("vehicle not found"));
        vehicleRepository.deleteById(id);
        return deleted;
    }
}
