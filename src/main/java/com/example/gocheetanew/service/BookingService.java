package com.example.gocheetanew.service;

import com.example.gocheetanew.model.Booking;
import com.example.gocheetanew.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private BookingRepository bookingRepository;

    public Booking create(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<Booking> findAll(){
        return bookingRepository.findAllByOrderByIdDesc();
    }

    public Booking findById(long id){
        return bookingRepository.findById(id).orElseThrow(()->new RuntimeException("booking not found"));
    }

    public Booking delete(long id){
        Booking delete = findById(id);
        bookingRepository.deleteById(id);
        return delete;
    }

    public List<Booking> findByDriverId(long id){
        return bookingRepository.findAllByDriver_IdOrderByIdDesc(id);
    }

    public List<Booking> findByCustomerId(long id){
        return  bookingRepository.findAllByCustomer_IdOrderByIdDesc(id);
    }

    public List<Booking> findByCategoryId(long id){
        return  bookingRepository.findAllByCategory_IdOrderByIdDesc(id);
    }

    public List<Booking> findByVehicleId(long id){
        return  bookingRepository.findAllByVehicle_IdOrderByIdDesc(id);
    }
}
