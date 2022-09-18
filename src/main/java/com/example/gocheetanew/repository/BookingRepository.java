package com.example.gocheetanew.repository;

import com.example.gocheetanew.model.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByDriver_IdOrderByIdDesc(long id);
    List<Booking> findAllByCustomer_IdOrderByIdDesc(long id);
    List<Booking> findAllByCategory_IdOrderByIdDesc(long id);
    List<Booking> findAllByVehicle_IdOrderByIdDesc(long id);
    List<Booking> findAllByOrderByIdDesc();

}
