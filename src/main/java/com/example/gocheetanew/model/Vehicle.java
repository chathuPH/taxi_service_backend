package com.example.gocheetanew.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vehicleName")
    private String vehicleName;

    @Column(name = "numberplate" ,unique = true)
    private String numberPlate;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn(name="category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "driver")
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "branch")
    private Branch branch;

}
