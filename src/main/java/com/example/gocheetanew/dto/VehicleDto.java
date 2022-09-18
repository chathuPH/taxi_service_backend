package com.example.gocheetanew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor@Data
public class VehicleDto {
    private long id;
    private String vehicleName;
    private String numberPlate;
    private String status;
    private long driver;
    private long branch;
    private long category;
}
