package com.example.gocheetanew.controller;

import com.example.gocheetanew.dto.BookingDto;
import com.example.gocheetanew.model.Booking;
import com.example.gocheetanew.model.Branch;
import com.example.gocheetanew.service.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v1/booking")
public class BookingController {

    private BookingService bookingService;
    private VehicleService vehicleService;
    private CustomerService customerService;
    private DriverService driverService;
    private CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<Booking> create(@RequestBody BookingDto bookingDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;
        if(bookingDto == null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Booking booking = new Booking();
        booking.setSource(bookingDto.getSource());
        booking.setDistance(bookingDto.getDistance());
        booking.setDestination(bookingDto.getDestination());
        booking.setFee(bookingDto.getFee());
        booking.setStatus("pending");
        booking.setVehicle(vehicleService.findById(bookingDto.getVehicle()));
        booking.setDriver(booking.getVehicle().getDriver());
        booking.setCategory(booking.getVehicle().getCategory());
        booking.setCustomer(customerService.findById(bookingDto.getCustomer()));

        return new ResponseEntity<>(bookingService.create(booking),response);
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> update(@RequestBody BookingDto bookingDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;
        if(bookingDto == null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Booking booking = bookingService.findById(bookingDto.getId());
        booking.setSource(bookingDto.getSource());
        booking.setDistance(bookingDto.getDistance());
        booking.setDestination(bookingDto.getDestination());
        booking.setFee(bookingDto.getFee());
        booking.setVehicle(vehicleService.findById(bookingDto.getVehicle()));
        booking.setDriver(booking.getVehicle().getDriver());
        booking.setCategory(booking.getVehicle().getCategory());
        booking.setCustomer(customerService.findById(bookingDto.getCustomer()));

        return new ResponseEntity<>(bookingService.create(booking),response);
    }

    @PutMapping("/status")
    public ResponseEntity<Booking> updateStatus(@RequestBody BookingDto bookingDto){
        HttpStatus response  = HttpStatus.EXPECTATION_FAILED;
        if(bookingDto == null){
            response = HttpStatus.BAD_REQUEST;
        }else{
            response = HttpStatus.CREATED;
        }

        Booking booking =bookingService.findById(bookingDto.getId());
        booking.setStatus(bookingDto.getStatus());

        return new ResponseEntity<>(bookingService.create(booking),response);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Booking>> findAll(){
        return new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/findByDriver")
    public ResponseEntity<List<Booking>> findAllByDriver(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(bookingService.findByDriverId(id),HttpStatus.OK);
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<List<Booking>> findAllByCategory(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(bookingService.findByCategoryId(id),HttpStatus.OK);
    }

    @GetMapping("/findByCustomer")
    public ResponseEntity<List<Booking>> findAllByCustomer(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(bookingService.findByCustomerId(id),HttpStatus.OK);
    }

    @GetMapping("/findByVehicle")
    public ResponseEntity<List<Booking>> findAllByVehicle(@RequestParam(name = "id") long id){
        return new ResponseEntity<>(bookingService.findByVehicleId(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Booking> delete(@RequestParam(name = "id") long id) {

        HttpStatus response = HttpStatus.EXPECTATION_FAILED;
        Booking deleted = bookingService.findById(id);

        try{
            bookingService.delete(id);
            response = HttpStatus.ACCEPTED;

        }catch (Exception e){
            response = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(deleted, response);

    }
}
