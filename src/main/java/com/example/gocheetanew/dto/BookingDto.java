package com.example.gocheetanew.dto;

import com.example.gocheetanew.model.Category;
import com.example.gocheetanew.model.Customer;
import com.example.gocheetanew.model.Driver;
import com.example.gocheetanew.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {

    private long id;
    private double fee;
    private String source;
    private String destination;
    private double distance;
    private String status;
    private long driver;
    private long vehicle;
    private long customer;
    private long category;
}
