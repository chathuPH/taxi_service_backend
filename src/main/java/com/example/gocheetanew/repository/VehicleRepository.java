package com.example.gocheetanew.repository;

import com.example.gocheetanew.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findAllByCategory_IdAndStatus(long id, String status);
    List<Vehicle> findAllByDriver_Id(long id);
}
