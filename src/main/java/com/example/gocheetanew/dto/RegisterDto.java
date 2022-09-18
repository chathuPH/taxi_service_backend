package com.example.gocheetanew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {

    private String type;
    private String username;
    private String password;
    private String customerName;
    private String contactNo;
    private String driverName;
    private String status;
    private long vehicleId;
    private long branchId;
    private long driverId;
    private long customerId;
}
