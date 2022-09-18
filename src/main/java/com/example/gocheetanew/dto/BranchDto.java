package com.example.gocheetanew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchDto {

    private long id;
    private String branchName;
    private String location;
    private String contactNo;
}
